package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

public interface BeerService {
    BeerDto getBeerById(Long valueOf);

    BeerDto saveBeerDto(BeerDto beerDto);
}
