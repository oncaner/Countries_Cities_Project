package enoca.enocaExample.business.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityByPopulationRequest {

    @NotNull
    private long id;

    @NotNull
    private BigInteger population;

}
