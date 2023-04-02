package enoca.enocaExample.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityByRegionRequest {

    @NotNull
    private long id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String region;

}
