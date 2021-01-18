package com.silasgah.msscbrewery.service;

import com.silasgah.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID Id);

    CustomerDto savedNewCustomer(CustomerDto customerDto);

    void updateCusomter(UUID id, CustomerDto customerDto);

    void deleteById(UUID id);
}
