package com.grobkar.spring6restmvc.services;

import com.grobkar.spring6restmvc.model.Beer;
import com.grobkar.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    Map<UUID,Beer> beerMap;
    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456")
                .price(new BigDecimal("12.99"))
                .quantityInHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityInHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityInHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        beerMap.put(beer1.getId(),beer1);
        beerMap.put(beer2.getId(),beer2);
        beerMap.put(beer3.getId(),beer3);
    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }
    @Override
    public Optional<Beer> getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());
        return Optional.of(beerMap.get(id));

    }

    @Override
    public Beer saveNewBeer(Beer beer) {

        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityInHand(beer.getQuantityInHand())
                .price(beer.getPrice())
                .version(1)
                .upc(beer.getUpc())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(savedBeer.getId(),savedBeer);

        return savedBeer;
    }

    @Override
    public void updateBeerById(UUID id, Beer beer) {
        Beer existingBeer = beerMap.get(id);

        existingBeer.setPrice(beer.getPrice());
        existingBeer.setBeerStyle(beer.getBeerStyle());
        existingBeer.setBeerName(beer.getBeerName());
        existingBeer.setUpc(beer.getUpc());
        existingBeer.setQuantityInHand(beer.getQuantityInHand());

        beerMap.put(existingBeer.getId(),existingBeer);
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove((beerId));
    }

    @Override
    public void patchById(UUID beerId,Beer beer) {
        Beer existingBeer = beerMap.get(beerId);

        if(StringUtils.hasText(beer.getBeerName())){
            existingBeer.setBeerName(beer.getBeerName());
        }

        if(beer.getBeerStyle() != null){
            existingBeer.setBeerStyle(beer.getBeerStyle());
        }

        if(beer.getPrice() != null){
            existingBeer.setPrice(beer.getPrice());
        }

        if(beer.getQuantityInHand() != null){
            existingBeer.setQuantityInHand(beer.getQuantityInHand());
        }

        if(StringUtils.hasText(beer.getUpc())){
            existingBeer.setUpc(beer.getUpc());
        }

    }
}
