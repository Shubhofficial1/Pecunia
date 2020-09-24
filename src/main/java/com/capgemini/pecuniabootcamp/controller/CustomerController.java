package com.capgemini.pecuniabootcamp.controller;


import com.capgemini.pecuniabootcamp.model.CustomerModel;
import com.capgemini.pecuniabootcamp.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;


    // get all customers in the database  --working fine
    @GetMapping
    public ResponseEntity<List<CustomerModel>> getAllCustomers(){
        return ResponseEntity.ok().body(customerServiceImpl.getAllCustomers());
    }

    // get customer by id  -- workign fine

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable long id){
        return ResponseEntity.ok().body(customerServiceImpl.getCustomerById(id));
    }

    // create customer  -- working fine

    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer( @RequestBody CustomerModel customer){
        return ResponseEntity.ok().body(this.customerServiceImpl.createCustomer(customer));
    }

    //update customer information

    @PutMapping("/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel customer, @PathVariable long id){
        customer.setId(id);
        return ResponseEntity.ok().body(this.customerServiceImpl.updateCustomer(customer));
    }

    // delete customer by id

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id){
        customerServiceImpl.deleteCustomer(id);
        return new ResponseEntity<>("Account DELETED", HttpStatus.OK);
    }


//
//    @PutMapping("/debit/{id}/{amount}")
//    public void updatedebit(@PathVariable(name="id") long id,@PathVariable(name="amount") double amount) {
//        customerServiceImpl.updatedebit(id, amount);
//    }
//    @PutMapping("/credit/{beneid}/{amount}")
//    public  void updatecredit(@PathVariable(name="beneid") long beneid,@PathVariable(name="amount") double amount) {
//        customerServiceImpl.updatecredit(beneid, amount);
//    }
//    @PutMapping("/slip/{id}/{amount}/{type}")
//    public void update(@PathVariable(name="id") long id,@PathVariable(name="amount") double amount,@PathVariable(name="type") String type) {
//        customerServiceImpl.update(id, amount,type);
//    }



}
