package enoca.enocaExample.dto.converter;

import enoca.enocaExample.model.City;
import org.springframework.stereotype.Component;

@Component
public class CityDtoConverter {

    public CityDto convertToDto(City city) {
        return new CityDto(
                city.getName(),
                city.getPopulation(),
                city.getRegion(),
                city.getCountry().getName()
        );
    }

}
