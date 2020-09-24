package com.capgemini.pecuniabootcamp.service;


import com.capgemini.pecuniabootcamp.entities.CustomerEntity;
import com.capgemini.pecuniabootcamp.exception.ResourceNotFoundException;
import com.capgemini.pecuniabootcamp.model.CustomerModel;
import com.capgemini.pecuniabootcamp.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository cr;

    public CustomerEntity of(CustomerModel source) {
        CustomerEntity entity=null;
        if(source!=null) {
            entity=new CustomerEntity();
            entity.setName(source.getName());
            entity.setContactNumber(source.getContactNumber());
            entity.setAadharNumber(source.getAadharNumber());
            entity.setPanNumber(source.getPanNumber());
            entity.setGender(source.getGender());
            entity.setDateOfBirth(source.getDateOfBirth());
            entity.setAddress(source.getAddress());
            entity.setCity(source.getCity());
            entity.setState(source.getState());
            entity.setCountry(source.getCountry());
            entity.setZipCode(source.getZipCode());
            entity.setStatus(source.getStatus());
            entity.setBalance(source.getBalance());
            entity.setCreditScore(source.getCreditScore());
        }
        return entity;
    }
    public CustomerModel of(CustomerEntity source) {
        CustomerModel model=null;
        if(source!=null) {

            model=new CustomerModel();
            model.setId(source.getId());
            model.setName(source.getName());
            model.setContactNumber(source.getContactNumber());
            model.setAadharNumber(source.getAadharNumber());
            model.setPanNumber(source.getPanNumber());
            model.setGender(source.getGender());
            model.setDateOfBirth(source.getDateOfBirth());
            model.setAddress(source.getAddress());
            model.setCity(source.getCity());
            model.setState(source.getState());
            model.setCountry(source.getCountry());
            model.setZipCode(source.getZipCode());
            model.setStatus(source.getStatus());
            model.setBalance(source.getBalance());
            model.setCreditScore(source.getCreditScore());
        }
        return model;
    }

    @Override
    public CustomerModel createCustomer(CustomerModel customer) {

        CustomerEntity entity=of(customer);
        long n = 100000000000L + new Random().nextInt(90000000);
        entity.setId(n);
        return of(cr.save(entity));
    }

    @Override
    public List<CustomerModel> getAllCustomers(){
        return cr.findAll().stream().map(e -> of(e)).collect(Collectors.toList());
    }

    @Override
    public CustomerModel getCustomerById(long id) {
        CustomerEntity customer =cr.findById(id).orElse(null);

        if (customer!=null) {
            return of(customer);
        }
        else {
            throw new ResourceNotFoundException("Record Not Found with id: " +id);
        }
    }

    @Override
    public CustomerModel updateCustomer(CustomerModel model) {
        CustomerEntity customer =cr.findById(model.getId()).orElse(null);

        if (customer!=null) {
            customer.setName(model.getName());
            customer.setContactNumber(model.getContactNumber());
            customer.setAddress(model.getAddress());
            customer.setCity(model.getCity());
            customer.setState(model.getState());
            customer.setCountry(model.getCountry());
            customer.setZipCode(model.getZipCode());
            customer.setCreditScore(model.getCreditScore());
            cr.save(customer);
            return of(customer);

        }
        else {

            throw new ResourceNotFoundException("Record Not Found with id: " +model.getId());
        }
    }

    @Override
    public void deleteCustomer(long id) {
        CustomerEntity customer =cr.findById(id).orElse(null);

        if (customer!=null) {
            cr.delete(customer);
        }
        else {
            throw new ResourceNotFoundException("Record Not Found with id: " +id);
        }

    }
    public void updatedebit(long id, double amount) {
        CustomerEntity entity=cr.findById(id).orElse(null);
        if(entity!=null) {
            entity.setBalance(entity.getBalance()-amount);
            cr.save(entity);
        }
    }


    public void updatecredit(long beneid, double amount) {
        CustomerEntity entity=cr.findById(beneid).orElse(null);
        if(entity!=null) {
            entity.setBalance(entity.getBalance()+amount);
            cr.save(entity);

        }
    }

    public void update(long id, double amount,String type) {
        CustomerEntity entity=cr.findById(id).orElse(null);
        if(entity!=null) {
            if(type.equals("credit"))
                entity.setBalance(entity.getBalance()+amount);
            else if(type.equals("debit"))
                entity.setBalance(entity.getBalance()-amount);
            cr.save(entity);

        }
    }


}





