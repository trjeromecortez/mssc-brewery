package com.trjerome.msscbrewery.web.services;

import com.trjerome.msscbrewery.web.model.BeerDto;

import java.util.UUID;

@Deprecated
public interface BeerService {
    BeerDto getByBeerId(UUID beerId);
    BeerDto getBeer();

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
