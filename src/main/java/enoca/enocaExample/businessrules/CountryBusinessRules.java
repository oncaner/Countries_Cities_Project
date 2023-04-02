package enoca.enocaExample.businessrules;

import enoca.enocaExample.exception.CountryNotFoundException;
import enoca.enocaExample.repository.CountryRepository;
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
