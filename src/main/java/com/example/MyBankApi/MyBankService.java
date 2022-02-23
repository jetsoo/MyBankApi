package com.example.MyBankApi;

import com.example.MyBankApi.Entity.Customer;
import com.example.MyBankApi.Entity.Konto;
import com.example.MyBankApi.Repository.CustomerRepository;
import com.example.MyBankApi.Repository.KontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyBankService {
    private final CustomerRepository customerRepository;
    private  final KontoRepository kontoRepository;

    @Autowired
    public MyBankService(CustomerRepository customerRepository,KontoRepository kontoRepository){
        this.customerRepository = customerRepository;
        this.kontoRepository = kontoRepository;
    }

    //BASIC CRUD FOR KONTO
    public Iterable<Konto> getAllKontos() {
        return this.kontoRepository.findAll();
    }

    public Optional<Konto> getKontoById(Long id) {
        return this.kontoRepository.findById(id);
    }

    public void updateKontoById(Long id,Konto konto) {
        Optional<Konto> kontoOptional = this.kontoRepository.findById(id);
        if(kontoOptional.isEmpty()){
            throw new RuntimeException("Konto with given id not found!");
        }
        Konto kontoUpdate = konto;
        this.kontoRepository.save(kontoUpdate);

    }

    public void addNewKonto(Konto konto) {
        this.kontoRepository.save(konto);
    }

    public void deleteKontoById(Long id) {
        Optional<Konto> kontoOptional = this.kontoRepository.findById(id);
        if(kontoOptional.isEmpty()){
            throw new RuntimeException("Konto with given id not found!");
        }
        this.kontoRepository.deleteById(id);
    }

    //BASIC CRUD FOR CUSTOMER
    public Iterable<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return this.customerRepository.findById(id);
    }

    public void updateCustomerById(Long id, Customer customer) {
        Optional<Customer> customerOptional = this.customerRepository.findById(id);
        if(customerOptional.isEmpty()){
            throw new RuntimeException("Customer with given id not found!");
        }
        Customer customerUpdate = customer;
        this.customerRepository.save(customerUpdate);
    }

    public void addNewCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }


    public void deleteCustomerById(Long id) {
        Optional<Customer> customerOptional = this.customerRepository.findById(id);
        if(customerOptional.isEmpty()){
            throw new RuntimeException("Customer with given id not found!");
        }
        this.customerRepository.deleteById(id);
    }
}
