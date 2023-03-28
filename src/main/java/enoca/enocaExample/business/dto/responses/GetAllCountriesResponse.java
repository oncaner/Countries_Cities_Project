package enoca.enocaExample.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCountriesResponse {
    private long id;

    private String name;

    private String continent;

    private BigInteger population;
}
