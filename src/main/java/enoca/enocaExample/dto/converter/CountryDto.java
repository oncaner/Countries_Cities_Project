package enoca.enocaExample.dto.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private String name;

    private String continent;

    private BigInteger population;
}
