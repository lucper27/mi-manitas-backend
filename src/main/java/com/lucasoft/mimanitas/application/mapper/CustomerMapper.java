package com.lucasoft.mimanitas.application.mapper;

import com.lucasoft.mimanitas.application.dto.CustomerDTO;
import com.lucasoft.mimanitas.domain.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer>{
}
