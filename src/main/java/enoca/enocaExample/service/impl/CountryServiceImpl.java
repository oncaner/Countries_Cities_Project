package enoca.enocaExample.service.impl;

import enoca.enocaExample.dto.requests.*;
import enoca.enocaExample.dto.responses.GetAllCountriesResponse;
import enoca.enocaExample.dto.responses.GetByIdCountryResponse;
import enoca.enocaExample.businessrules.CountryBusinessRules;
import enoca.enocaExample.exception.BusinessException;
import enoca.enocaExample.config.mappers.ModelMapperService;
import enoca.enocaExample.repository.CountryRepository;
import enoca.enocaExample.model.Country;
import enoca.enocaExample.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private ModelMapperService modelMapperService;
    private CountryBusinessRules countryBusinessRules;

    @Override
    public List<GetAllCountriesResponse> getAll() {
        List<Country> countries = countryRepository.findAll();

        List<GetAllCountriesResponse> getAllCountriesResponses = countries.stream().map(country -> this.modelMapperService.forResponse().map(country, GetAllCountriesResponse.class)).toList();

        return getAllCountriesResponses;
    }

    @Override
    public GetByIdCountryResponse getById(long id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new BusinessException(String.format("Country not found with: %d", id)));

        GetByIdCountryResponse getByIdCountryResponse = this.modelMapperService.forResponse().map(country, GetByIdCountryResponse.class);

        return getByIdCountryResponse;
    }

    @Override
    public Country create(CreateCountryRequest createCountryRequest) {
        Country country = this.modelMapperService.forRequest().map(createCountryRequest, Country.class);

        return this.countryRepository.save(country);
    }

    @Override
    public Country update(UpdateCountryRequest updateCountryRequest) {
        this.countryBusinessRules.checkIfCountryIdNotExists(updateCountryRequest.getId());

        Country country = this.modelMapperService.forRequest().map(updateCountryRequest, Country.class);

        return this.countryRepository.save(country);
    }

    @Override
    public Country updateByContinent(UpdateCountryByContinentRequest updateCountryByContinentRequest) {
        this.countryBusinessRules.checkIfCountryIdNotExists(updateCountryByContinentRequest.getId());

        Country country = countryRepository.findById(updateCountryByContinentRequest.getId()).orElseThrow();
        country.setContinent(updateCountryByContinentRequest.getContinent());

        return this.countryRepository.save(country);
    }

    @Override
    public Country updateByName(UpdateCountryByNameRequest updateCountryByNameRequest) {
        this.countryBusinessRules.checkIfCountryIdNotExists(updateCountryByNameRequest.getId());

        Country country = countryRepository.findById(updateCountryByNameRequest.getId()).orElseThrow();
        country.setName(updateCountryByNameRequest.getName());

        return this.countryRepository.save(country);
    }

    @Override
    public Country updateByPopulation(UpdateCountryByPopulationRequest updateCountryByPopulationRequest) {
        this.countryBusinessRules.checkIfCountryIdNotExists(updateCountryByPopulationRequest.getId());

        Country country = countryRepository.findById(updateCountryByPopulationRequest.getId()).orElseThrow();
        country.setPopulation(updateCountryByPopulationRequest.getPopulation());

        return this.countryRepository.save(country);
    }

    @Override
    public void delete(long id) {
        this.countryBusinessRules.checkIfCountryIdNotExists(id);

        this.countryRepository.deleteById(id);
    }
}
