package com.trjerome.msscbrewery.web.services.v2;

import com.trjerome.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDto getByBeerId(UUID beerId);
    BeerDto getBeer();

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
