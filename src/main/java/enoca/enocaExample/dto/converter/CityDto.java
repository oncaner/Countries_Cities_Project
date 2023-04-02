package enoca.enocaExample.dto.converter;

import enoca.enocaExample.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    private String name;

    private BigInteger population;

    private String region;

    private String countryName;

}
