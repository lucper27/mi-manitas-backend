package com.lucasoft.mimanitas.application.service.implementation;

import com.lucasoft.mimanitas.application.dto.CustomerDTO;
import com.lucasoft.mimanitas.application.mapper.CustomerMapper;
import com.lucasoft.mimanitas.application.service.CustomerService;
import com.lucasoft.mimanitas.domain.entity.Customer;
import com.lucasoft.mimanitas.domain.persistence.CustomerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerPersistence customerPersistence;

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerPersistence customerPersistence, CustomerMapper customerMapper) {
        this.customerPersistence = customerPersistence;
        this.customerMapper = customerMapper;
    }


    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = this.customerPersistence.getCustomerById(id);
        return this.customerMapper.toDto(customer);
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = this.customerPersistence.save(this.customerMapper.toEntity(customerDTO));
        return this.customerMapper.toDto(customer);
    }
}
