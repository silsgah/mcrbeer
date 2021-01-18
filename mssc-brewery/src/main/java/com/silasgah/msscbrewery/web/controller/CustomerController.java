package com.silasgah.msscbrewery.web.controller;

import com.silasgah.msscbrewery.service.CustomerService;
import com.silasgah.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @RequestMapping("{Id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("Id") UUID Id){
        return new ResponseEntity<>(customerService.getCustomerById(Id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto saveCustomer = customerService.savedNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + saveCustomer.getId().toString());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{Id}")
    public ResponseEntity handleUpdate(@PathVariable("Id") UUID Id,@RequestBody CustomerDto customerDto){
        customerService.updateCusomter(Id, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("Id") UUID Id){
        customerService.deleteById(Id);
    }
}
