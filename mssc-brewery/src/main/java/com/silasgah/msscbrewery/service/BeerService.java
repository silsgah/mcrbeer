package com.silasgah.msscbrewery.service;

import com.silasgah.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto savedNewBeer(BeerDto beerDto);

    void updateBeer(UUID id, BeerDto beerDto);

    void deleteById(UUID id);
}
