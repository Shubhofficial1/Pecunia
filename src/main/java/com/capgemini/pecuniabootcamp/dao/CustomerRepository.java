package com.capgemini.pecuniabootcamp.dao;

import com.capgemini.pecuniabootcamp.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
