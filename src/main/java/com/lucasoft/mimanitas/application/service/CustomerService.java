package com.lucasoft.mimanitas.application.service;

import com.lucasoft.mimanitas.application.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO getCustomerById(Long id);

    CustomerDTO save(CustomerDTO customerDTO);
}
