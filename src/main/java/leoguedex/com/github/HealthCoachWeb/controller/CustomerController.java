package leoguedex.com.github.HealthCoachWeb.controller;

import leoguedex.com.github.HealthCoachWeb.exception.GetAgeFromBirthDateException;
import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import leoguedex.com.github.HealthCoachWeb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping
  public ResponseEntity<Customer> create(@RequestBody Customer customer) {
    Customer savedCustomer = customerService.create(customer);

    URI result = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedCustomer.getId()).toUri();

    return ResponseEntity.created(result).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    customerService.delete(id);

    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> findById(@PathVariable Long id) {
    Customer result = customerService.findById(id);

    return ResponseEntity.ok().body(result);
  }

  @GetMapping
  public ResponseEntity<List<Customer>> findAllCustomers() throws GetAgeFromBirthDateException {
    List<Customer> result = customerService.findAllCustomers();

    return ResponseEntity.ok().body(result);
  }

}
