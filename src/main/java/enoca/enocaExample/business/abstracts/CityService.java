package enoca.enocaExample.business.abstracts;

import enoca.enocaExample.business.dto.requests.*;
import enoca.enocaExample.business.dto.responses.GetAllCitiesResponse;
import enoca.enocaExample.business.dto.responses.GetByIdCityResponse;
import enoca.enocaExample.entities.concretes.City;

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
