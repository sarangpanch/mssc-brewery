package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID valueOf) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Budwiser").beerStyle("Pale ale").upc(4L).build();
    }

    @Override
    public BeerDto saveBeerDto(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Stella").build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        BeerDto.builder().id(beerId).beerName(beerDto.getBeerName()).beerStyle(beerDto.getBeerStyle()).build();
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("delete beer with id.." + beerId.toString());
    }
}
