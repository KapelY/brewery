package com.zigmann.brewery.services;

import com.zigmann.brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Ivan")
                .beerStyle("SuperStyle")
                .upc(123L)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();

    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // todo update beer
    }

}
