package enoca.enocaExample.service.impl;


import enoca.enocaExample.dto.requests.CreateCityRequest;
import enoca.enocaExample.dto.requests.UpdateCityByNameRequest;
import enoca.enocaExample.dto.requests.UpdateCityByPopulationRequest;
import enoca.enocaExample.dto.requests.UpdateCityByRegionRequest;
import enoca.enocaExample.dto.requests.UpdateCityRequest;
import enoca.enocaExample.dto.responses.GetAllCitiesResponse;
import enoca.enocaExample.dto.responses.GetByIdCityResponse;
import enoca.enocaExample.businessrules.CityBusinessRules;
import enoca.enocaExample.businessrules.CountryBusinessRules;
import enoca.enocaExample.config.mappers.ModelMapperService;
import enoca.enocaExample.repository.CityRepository;
import enoca.enocaExample.repository.CountryRepository;
import enoca.enocaExample.model.City;
import enoca.enocaExample.model.Country;
import enoca.enocaExample.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private ModelMapperService modelMapperService;
    private CityBusinessRules cityBusinessRules;
    private CountryBusinessRules countryBusinessRules;

    @Override
    public List<GetAllCitiesResponse> getAll() {
        List<City> cities = cityRepository.findAll();

        List<GetAllCitiesResponse> responseList = cities.stream().map(city -> this.modelMapperService.forResponse().map(city, GetAllCitiesResponse.class)).toList();

        return responseList;
    }

    @Override
    public GetByIdCityResponse getById(long id) {
        cityBusinessRules.checkIfCityIdNotExists(id);

        City city = cityRepository.findById(id).orElseThrow();

        GetByIdCityResponse response = this.modelMapperService.forResponse().map(city, GetByIdCityResponse.class);

        return response;
    }

    @Override
    public City create(CreateCityRequest createCityRequest) {
        countryBusinessRules.checkIfCountryIdNotExists(createCityRequest.getCountryId());

        City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);

        return this.cityRepository.save(city);
    }

    @Override
    public City update(UpdateCityRequest updateCityRequest) {
        cityBusinessRules.checkIfCityIdNotExists(updateCityRequest.getId());

        City oldCity = this.cityRepository.findById(updateCityRequest.getId()).orElseThrow();
        Country country = this.countryRepository.findById(oldCity.getCountry().getId()).orElseThrow();

        City updateCity = this.modelMapperService.forRequest().map(updateCityRequest, City.class);
        updateCity.setCountry(country);

        return this.cityRepository.save(updateCity);
    }

    @Override
    public City updateByName(UpdateCityByNameRequest updateCityByNameRequest) {
        this.cityBusinessRules.checkIfCityIdNotExists(updateCityByNameRequest.getId());

        City city = this.cityRepository.findById(updateCityByNameRequest.getId()).orElseThrow();
        city.setName(updateCityByNameRequest.getName());

        return this.cityRepository.save(city);
    }

    @Override
    public City updateByPopulation(UpdateCityByPopulationRequest updateCityByPopulationRequest) {
        this.cityBusinessRules.checkIfCityIdNotExists(updateCityByPopulationRequest.getId());

        City city = this.cityRepository.findById(updateCityByPopulationRequest.getId()).orElseThrow();
        city.setPopulation(updateCityByPopulationRequest.getPopulation());

        return this.cityRepository.save(city);
    }

    @Override
    public City updateByRegion(UpdateCityByRegionRequest updateCityByRegionRequest) {
        this.cityBusinessRules.checkIfCityIdNotExists(updateCityByRegionRequest.getId());

        City city = this.cityRepository.findById(updateCityByRegionRequest.getId()).orElseThrow();
        city.setRegion(updateCityByRegionRequest.getRegion());

        return this.cityRepository.save(city);
    }

    @Override
    public void delete(long id) {
        cityBusinessRules.checkIfCityIdNotExists(id);

        this.cityRepository.deleteById(id);
    }
}
