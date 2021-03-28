package com.silasgah.msscbrewery.web.mappers;

import com.silasgah.msscbrewery.domain.Customer;
import com.silasgah.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto dto);

    CustomerDto DtoToCustomer(CustomerDto customer);
}
