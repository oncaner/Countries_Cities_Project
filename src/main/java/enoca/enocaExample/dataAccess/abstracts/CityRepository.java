package enoca.enocaExample.dataAccess.abstracts;

import enoca.enocaExample.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
