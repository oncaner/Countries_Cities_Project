package enoca.enocaExample.service;

import enoca.enocaExample.dto.requests.CreateCityRequest;
import enoca.enocaExample.dto.requests.UpdateCityByNameRequest;
import enoca.enocaExample.dto.requests.UpdateCityByPopulationRequest;
import enoca.enocaExample.dto.requests.UpdateCityByRegionRequest;
import enoca.enocaExample.dto.requests.UpdateCityRequest;
import enoca.enocaExample.dto.responses.GetAllCitiesResponse;
import enoca.enocaExample.dto.responses.GetByIdCityResponse;
import enoca.enocaExample.model.City;

import java.util.List;

public interface CityService {

    List<GetAllCitiesResponse> getAll();

    GetByIdCityResponse getById(long id);

    City create(CreateCityRequest createCityRequest);

    City update(UpdateCityRequest updateCityRequest);

    City updateByName(UpdateCityByNameRequest updateCityByNameRequest);

    City updateByPopulation(UpdateCityByPopulationRequest updateCityByPopulationRequest);

    City updateByRegion(UpdateCityByRegionRequest updateCityByRegionRequest);

    void delete(long id);
}
