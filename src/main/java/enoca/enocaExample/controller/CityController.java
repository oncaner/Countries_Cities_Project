package enoca.enocaExample.controller;

import enoca.enocaExample.dto.converter.CityDto;
import enoca.enocaExample.dto.converter.CityDtoConverter;

import enoca.enocaExample.dto.requests.CreateCityRequest;
import enoca.enocaExample.dto.requests.UpdateCityByNameRequest;
import enoca.enocaExample.dto.requests.UpdateCityByPopulationRequest;
import enoca.enocaExample.dto.requests.UpdateCityByRegionRequest;
import enoca.enocaExample.dto.requests.UpdateCityRequest;
import enoca.enocaExample.dto.responses.GetAllCitiesResponse;
import enoca.enocaExample.dto.responses.GetByIdCityResponse;
import enoca.enocaExample.model.City;
import enoca.enocaExample.service.CityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    private final CityDtoConverter cityDtoConverter;

    @GetMapping()
    public ResponseEntity<List<GetAllCitiesResponse>> getAll() {
        List<GetAllCitiesResponse> response = this.cityService.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCityResponse> getById(@PathVariable Long id) {
        GetByIdCityResponse response = this.cityService.getById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CityDto> create(@RequestBody @Valid CreateCityRequest createCityRequest) {
        City city = this.cityService.create(createCityRequest);

        return new ResponseEntity<>(cityDtoConverter.convertToDto(city), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CityDto> update(@RequestBody @Valid UpdateCityRequest updateCityRequest) {
        City city = this.cityService.update(updateCityRequest);

        return new ResponseEntity<>(cityDtoConverter.convertToDto(city), HttpStatus.OK);
    }

    @PatchMapping("/update/by-name")
    public ResponseEntity<CityDto> updateByName(@RequestBody @Valid UpdateCityByNameRequest request) {
        City city = this.cityService.updateByName(request);

        return new ResponseEntity<>(cityDtoConverter.convertToDto(city), HttpStatus.OK);
    }

    @PatchMapping("/update/by-population")
    public ResponseEntity<CityDto> updateByPopulation(@RequestBody @Valid UpdateCityByPopulationRequest request) {
        City city = this.cityService.updateByPopulation(request);

        return new ResponseEntity<>(cityDtoConverter.convertToDto(city), HttpStatus.OK);
    }

    @PatchMapping("/update/by-region")
    public ResponseEntity<CityDto> updateByRegion(@RequestBody @Valid UpdateCityByRegionRequest request) {
        City city = this.cityService.updateByRegion(request);

        return new ResponseEntity<>(cityDtoConverter.convertToDto(city), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.cityService.delete(id);
    }

}
