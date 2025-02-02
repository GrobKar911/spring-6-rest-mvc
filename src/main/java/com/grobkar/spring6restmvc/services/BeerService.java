package com.grobkar.spring6restmvc.services;

import com.grobkar.spring6restmvc.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Optional<Beer> getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID id, Beer beer);

    void deleteById(UUID beerId);

    void patchById(UUID beerId,Beer beer);
}
