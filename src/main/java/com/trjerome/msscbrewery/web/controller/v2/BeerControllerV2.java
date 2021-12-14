package com.trjerome.msscbrewery.web.controller.v2;

import com.trjerome.msscbrewery.web.model.BeerDto;
import com.trjerome.msscbrewery.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServiceV2 = beerService;
    }

    @GetMapping({"/"})
    public ResponseEntity<BeerDto> getBeer() {
        return new ResponseEntity<>(beerServiceV2.getBeer(), HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getByBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping // CREATE new Beer
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
        BeerDto savedBeerDto = beerServiceV2.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to URL
        headers.add("Location", "/api/v1/beer/" + savedBeerDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"}) // UPSERT Beer
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"}) // DELETE Beer
    public ResponseEntity handleDelete(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteBeer(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
