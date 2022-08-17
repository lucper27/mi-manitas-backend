package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomersById(Long id);

    Customer save(Customer customer);
}
