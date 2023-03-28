package enoca.enocaExample.webApi.controllers;

import enoca.enocaExample.business.abstracts.CityService;
import enoca.enocaExample.business.dto.requests.*;
import enoca.enocaExample.business.dto.responses.GetAllCitiesResponse;
import enoca.enocaExample.business.dto.responses.GetByIdCityResponse;
import enoca.enocaExample.entities.concretes.City;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CitiesController {

    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<List<GetAllCitiesResponse>> getAll() {
        List<GetAllCitiesResponse> response = this.cityService.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCityResponse> getById(@PathVariable long id) {
        GetByIdCityResponse response = this.cityService.getById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody @Valid CreateCityRequest createCityRequest) {
        City city = this.cityService.create(createCityRequest);

        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<City> update(@RequestBody @Valid UpdateCityRequest updateCityRequest) {
        City city = this.cityService.update(updateCityRequest);

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PatchMapping("/update/by-name")
    public ResponseEntity<City> updateByName(@RequestBody @Valid UpdateCityByNameRequest request) {
        City city = this.cityService.updateByName(request);

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PatchMapping("/update/by-population")
    public ResponseEntity<City> updateByPopulation(@RequestBody @Valid UpdateCityByPopulationRequest request) {
        City city = this.cityService.updateByPopulation(request);

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PatchMapping("/update/by-region")
    public ResponseEntity<City> updateByRegion(@RequestBody @Valid UpdateCityByRegionRequest request) {
        City city = this.cityService.updateByRegion(request);

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        this.cityService.delete(id);
    }

}
