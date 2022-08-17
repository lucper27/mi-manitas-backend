package com.lucasoft.mimanitas.domain.persistence;

import com.lucasoft.mimanitas.domain.entity.Customer;

public interface CustomerPersistence {

    Customer getCustomerById(Long id);

    Customer save(Customer customer);
}
