package enoca.enocaExample.service;

import enoca.enocaExample.dto.requests.CreateCountryRequest;
import enoca.enocaExample.dto.requests.UpdateCountryByContinentRequest;
import enoca.enocaExample.dto.requests.UpdateCountryByNameRequest;
import enoca.enocaExample.dto.requests.UpdateCountryByPopulationRequest;
import enoca.enocaExample.dto.requests.UpdateCountryRequest;
import enoca.enocaExample.dto.responses.GetAllCountriesResponse;
import enoca.enocaExample.dto.responses.GetByIdCountryResponse;
import enoca.enocaExample.model.Country;

import java.util.List;

public interface CountryService {
    List<GetAllCountriesResponse> getAll();

    GetByIdCountryResponse getById(long id);

    Country create(CreateCountryRequest createCountryRequest);

    Country update(UpdateCountryRequest updateCountryRequest);

    Country updateByContinent(UpdateCountryByContinentRequest updateCountryByContinentRequest);

    Country updateByName(UpdateCountryByNameRequest updateCountryByNameRequest);

    Country updateByPopulation(UpdateCountryByPopulationRequest updateCountryByPopulationRequest);

    void delete(long id);
}
