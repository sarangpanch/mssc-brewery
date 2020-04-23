package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(Long valueOf) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Budwiser").beerStyle("Pale ale").upc(4L).build();
    }

    @Override
    public BeerDto saveBeerDto(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Stella").build();
    }
}
