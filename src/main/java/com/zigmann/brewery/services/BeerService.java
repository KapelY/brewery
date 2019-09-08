package com.zigmann.brewery.services;

import com.zigmann.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeerById(UUID beerId, BeerDto beerDto);

    void deleteById();
}
