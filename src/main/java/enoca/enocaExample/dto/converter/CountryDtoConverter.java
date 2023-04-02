package enoca.enocaExample.dto.converter;

import enoca.enocaExample.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoConverter {

    public CountryDto convertToDto(Country country) {
        return new CountryDto(country.getName(),
                country.getContinent(),
                country.getPopulation());
    }

}
