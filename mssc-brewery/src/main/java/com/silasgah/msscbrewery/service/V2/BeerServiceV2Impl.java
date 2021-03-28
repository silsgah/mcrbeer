package com.silasgah.msscbrewery.service.V2;

import com.silasgah.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 savedNewBeer(BeerDtoV2 beerDtoV2) {
        return null;
    }

    @Override
    public void updateBeer(UUID id, BeerDtoV2 beerDtoV2) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
