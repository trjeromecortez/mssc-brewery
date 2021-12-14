package com.trjerome.msscbrewery.web.controller;

import com.trjerome.msscbrewery.web.model.BeerDto;
import com.trjerome.msscbrewery.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/"})
    public ResponseEntity<BeerDto> getBeer() {
        return new ResponseEntity<>(beerService.getBeer(), HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getByBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping // CREATE new Beer
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
        BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to URL
        headers.add("Location", "/api/v1/beer/" + savedBeerDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"}) // UPSERT Beer
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"}) // DELETE Beer
    public ResponseEntity handleDelete(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
