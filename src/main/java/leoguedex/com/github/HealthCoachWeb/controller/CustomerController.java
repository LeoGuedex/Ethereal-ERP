package leoguedex.com.github.HealthCoachWeb.controller;

import leoguedex.com.github.HealthCoachWeb.domain.Customer;
import leoguedex.com.github.HealthCoachWeb.repository.CustomerRepository;
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
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Customer customer) {
        customerRepository.save(customer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        customerRepository.save(customer);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok().body(customers);
    }

}
