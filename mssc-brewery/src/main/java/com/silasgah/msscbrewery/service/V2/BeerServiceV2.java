package com.silasgah.msscbrewery.service.V2;

import com.silasgah.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 savedNewBeer(BeerDtoV2 beerDtoV2);

    void updateBeer(UUID id, BeerDtoV2 beerDtoV2);

    void deleteById(UUID id);
}
