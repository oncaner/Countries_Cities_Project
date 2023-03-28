package enoca.enocaExample.business.rules;

import enoca.enocaExample.core.utilities.exceptions.CityNotFoundException;
import enoca.enocaExample.dataAccess.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityBusinessRules {

    private CityRepository cityRepository;

    public void checkIfCityIdNotExists(long id) {
        if (!cityRepository.existsById(id)) {
            throw new CityNotFoundException(String.format("City not found with: %d", id));
        }
    }

}
