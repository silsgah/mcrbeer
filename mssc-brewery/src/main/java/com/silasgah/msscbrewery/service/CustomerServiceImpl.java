package com.silasgah.msscbrewery.service;

import com.silasgah.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID Id) {
        return CustomerDto.builder().Id(UUID.randomUUID())
                .name("Silas Gah")
                .build();
    }

    @Override
    public CustomerDto savedNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().Id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCusomter(UUID id, CustomerDto customerDto) {
        log.debug("updating customer...");
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("delete record...");
    }
}
