package enoca.enocaExample.business.rules;

import enoca.enocaExample.core.utilities.exceptions.BusinessException;
import enoca.enocaExample.core.utilities.exceptions.CountryNotFoundException;
import enoca.enocaExample.dataAccess.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryBusinessRules {

    private CountryRepository countryRepository;

    public void checkIfCountryIdNotExists(long id) {
        if (!this.countryRepository.existsById(id)) {
            throw new CountryNotFoundException(String.format("Country not found with: %d", id));
        }
    }

}
