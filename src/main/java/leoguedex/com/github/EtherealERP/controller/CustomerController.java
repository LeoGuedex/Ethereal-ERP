package leoguedex.com.github.EtherealERP.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.transaction.Transactional;
import leoguedex.com.github.EtherealERP.domain.Customer;
import leoguedex.com.github.EtherealERP.domain.dto.AllCustomerDTO;
import leoguedex.com.github.EtherealERP.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @Transactional
    public URI create(@ModelAttribute("allCustomerDTO") AllCustomerDTO customer) {

        URI result = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(customerService.create(customer).getId()).toUri();

        return result;
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
    public ResponseEntity<List<Customer>> findAllCustomers() {
        List<Customer> result = customerService.findAllCustomers();

        return ResponseEntity.ok().body(result);
    }

}
