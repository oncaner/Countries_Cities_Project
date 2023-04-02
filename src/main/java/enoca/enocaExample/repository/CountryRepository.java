package enoca.enocaExample.repository;

import enoca.enocaExample.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
