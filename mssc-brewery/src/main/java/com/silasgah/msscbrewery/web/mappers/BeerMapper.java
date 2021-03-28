package com.silasgah.msscbrewery.web.mappers;

import com.silasgah.msscbrewery.domain.Beer;
import com.silasgah.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
