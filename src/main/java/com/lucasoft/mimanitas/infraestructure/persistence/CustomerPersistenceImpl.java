package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Customer;
import com.lucasoft.mimanitas.domain.persistence.CustomerPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerPersistenceImpl implements CustomerPersistence {

    private final CustomerRepository customerRepository;

    public CustomerPersistenceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return this.customerRepository.getCustomersById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
