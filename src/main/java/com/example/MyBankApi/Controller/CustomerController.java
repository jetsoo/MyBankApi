package com.example.MyBankApi.Controller;

import com.example.MyBankApi.Entity.Customer;
import com.example.MyBankApi.MyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("bankApi/v1/customer")
public class CustomerController {
    private final MyBankService myBankService;

    @Autowired
    public CustomerController(MyBankService myBankService){
        this.myBankService = myBankService;
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers(){
        return this.myBankService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable(name = "id") Long id){
        return this.myBankService.getCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCustomerById(@PathVariable(name = "id") Long id, @RequestBody Customer customer){
        this.myBankService.updateCustomerById(id,customer);
    }

    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer){
        this.myBankService.addNewCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable(name = "id") Long id){
        this.myBankService.deleteCustomerById(id);
    }
}
