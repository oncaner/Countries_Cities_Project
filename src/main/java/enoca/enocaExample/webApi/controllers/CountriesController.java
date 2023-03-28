package enoca.enocaExample.webApi.controllers;

import enoca.enocaExample.business.abstracts.CountryService;
import enoca.enocaExample.business.dto.requests.*;
import enoca.enocaExample.business.dto.responses.GetAllCountriesResponse;
import enoca.enocaExample.business.dto.responses.GetByIdCountryResponse;
import enoca.enocaExample.dataAccess.abstracts.CountryRepository;
import enoca.enocaExample.entities.concretes.Country;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/countries")
public class CountriesController {

    private final CountryService countryService;

    @GetMapping()
    public ResponseEntity<List<GetAllCountriesResponse>> getAll() {
        List<GetAllCountriesResponse> response = countryService.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCountryResponse> getById(@PathVariable long id) {
        GetByIdCountryResponse response = this.countryService.getById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Country> create(@RequestBody @Valid CreateCountryRequest createCountryRequest) {
        Country country = this.countryService.create(createCountryRequest);

        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Country> update(@RequestBody @Valid UpdateCountryRequest updateCountryRequest) {
        Country country = this.countryService.update(updateCountryRequest);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PatchMapping("/update/by-name")
    public ResponseEntity<Country> updateByName(@RequestBody @Valid UpdateCountryByNameRequest request) {
        Country country = this.countryService.updateByName(request);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PatchMapping("/update/by-continent")
    public ResponseEntity<Country> updateByContinent(@RequestBody @Valid UpdateCountryByContinentRequest request) {
        Country country = this.countryService.updateByContinent(request);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PatchMapping("/update/by-population")
    public ResponseEntity<Country> updateByPopulation(@RequestBody @Valid UpdateCountryByPopulationRequest request) {
        Country country = this.countryService.updateByPopulation(request);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        this.countryService.delete(id);
    }

}
