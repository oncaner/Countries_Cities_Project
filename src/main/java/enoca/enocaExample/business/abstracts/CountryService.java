package enoca.enocaExample.business.abstracts;

import enoca.enocaExample.business.dto.requests.*;
import enoca.enocaExample.business.dto.responses.GetAllCountriesResponse;
import enoca.enocaExample.business.dto.responses.GetByIdCountryResponse;
import enoca.enocaExample.entities.concretes.Country;

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
