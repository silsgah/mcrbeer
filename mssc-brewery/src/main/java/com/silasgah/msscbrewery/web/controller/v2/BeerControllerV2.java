package com.silasgah.msscbrewery.web.controller.v2;

import com.silasgah.msscbrewery.service.BeerService;
import com.silasgah.msscbrewery.service.V2.BeerServiceV2;
import com.silasgah.msscbrewery.web.model.BeerDto;
import com.silasgah.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServiceV2 = beerService;
    }

    @GetMapping
    @RequestMapping("{beerId}")
    public ResponseEntity<BeerDtoV2> getbeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDtoV2){
        BeerDtoV2 saveBeer = beerServiceV2.savedNewBeer(beerDtoV2);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + saveBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID Id,@Valid @RequestBody BeerDtoV2 beerDtoV2){
        beerServiceV2.updateBeer(Id, beerDtoV2);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID Id){
        beerServiceV2.deleteById(Id);
    }

}
