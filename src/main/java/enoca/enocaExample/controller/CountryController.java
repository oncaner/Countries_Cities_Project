package enoca.enocaExample.controller;

import enoca.enocaExample.dto.converter.CountryDto;
import enoca.enocaExample.dto.converter.CountryDtoConverter;
import enoca.enocaExample.dto.requests.CreateCountryRequest;
import enoca.enocaExample.dto.requests.UpdateCountryByContinentRequest;
import enoca.enocaExample.dto.requests.UpdateCountryByNameRequest;
import enoca.enocaExample.dto.requests.UpdateCountryRequest;
import enoca.enocaExample.dto.requests.UpdateCountryByPopulationRequest;
import enoca.enocaExample.dto.responses.GetAllCountriesResponse;
import enoca.enocaExample.dto.responses.GetByIdCountryResponse;
import enoca.enocaExample.model.Country;
import enoca.enocaExample.service.CountryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;
    private final CountryDtoConverter countryDtoConverter;

    @GetMapping()
    public ResponseEntity<List<GetAllCountriesResponse>> getAll() {
        List<GetAllCountriesResponse> response = countryService.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCountryResponse> getById(@PathVariable Long id) {
        GetByIdCountryResponse response = this.countryService.getById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CountryDto> create(@RequestBody @Valid CreateCountryRequest createCountryRequest) {
        Country country = this.countryService.create(createCountryRequest);

        return new ResponseEntity<>(countryDtoConverter.convertToDto(country), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CountryDto> update(@RequestBody @Valid UpdateCountryRequest updateCountryRequest) {
        Country country = this.countryService.update(updateCountryRequest);

        return new ResponseEntity<>(countryDtoConverter.convertToDto(country), HttpStatus.OK);
    }

    @PatchMapping("/update/by-name")
    public ResponseEntity<CountryDto> updateByName(@RequestBody @Valid UpdateCountryByNameRequest request) {
        Country country = this.countryService.updateByName(request);

        return new ResponseEntity<>(countryDtoConverter.convertToDto(country), HttpStatus.OK);
    }

    @PatchMapping("/update/by-continent")
    public ResponseEntity<CountryDto> updateByContinent(@RequestBody @Valid UpdateCountryByContinentRequest request) {
        Country country = this.countryService.updateByContinent(request);

        return new ResponseEntity<>(countryDtoConverter.convertToDto(country), HttpStatus.OK);
    }

    @PatchMapping("/update/by-population")
    public ResponseEntity<CountryDto> updateByPopulation(@RequestBody @Valid UpdateCountryByPopulationRequest request) {
        Country country = this.countryService.updateByPopulation(request);

        return new ResponseEntity<>(countryDtoConverter.convertToDto(country), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.countryService.delete(id);
    }

}
