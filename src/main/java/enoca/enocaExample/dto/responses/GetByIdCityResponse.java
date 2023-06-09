package enoca.enocaExample.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCityResponse {

    private long id;

    private String name;

    private BigInteger population;

    private String region;

    private String countryName;

}
