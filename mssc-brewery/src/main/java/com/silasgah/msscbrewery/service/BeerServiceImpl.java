package com.silasgah.msscbrewery.service;

import com.silasgah.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerid) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Silas Man")
                .beerStyle("African style")
                .build();
    }

    @Override
    public BeerDto savedNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        //yet to be implemented
    }

    @Override
    public void deleteById(UUID id) {
    log.debug("deleting ...");
    }

}
