package com.example.demospringboot.controller;


import com.example.demospringboot.model.Customer;
import com.example.demospringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @GetMapping("/all")
    public Iterable<Customer> getAllCustomer() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){

        return repo.save(customer);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer (@PathVariable long id){
        Customer updateCustomer = null;
        Optional<Customer> customer = repo.findById(id);
        if( customer.isPresent()){
            updateCustomer = customer.get();
            updateCustomer.setFirstName(updateCustomer.getFirstName() + "_updated");
        }

        return repo.save(updateCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        repo.deleteById(id);
    }
}
