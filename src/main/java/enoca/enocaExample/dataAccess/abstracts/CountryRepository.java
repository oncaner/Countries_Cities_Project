package enoca.enocaExample.dataAccess.abstracts;

import enoca.enocaExample.entities.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
