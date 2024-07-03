package com.grobkar.spring6restmvc.services;

import com.grobkar.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
