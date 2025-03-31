package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.enums.OPEN_CLOSE;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningInterval;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpeningIntervalMapperTest {

    private final OpeningIntervalMapper openingIntervalMapper = new OpeningIntervalMapper();

    @Test
    void apply_ShouldMapOpeningIntervalDTOToOpeningInterval() {
        PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO openingIntervalDTO =
                PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO.builder()
                        .start("11:30")
                        .end("18:30")
                        .type(OPEN_CLOSE.OPEN)
                        .build();

        OpeningInterval result = openingIntervalMapper.apply(openingIntervalDTO);

        assertThat(result.getStart()).isEqualTo("11:30");
        assertThat(result.getEnd()).isEqualTo("18:30");
        assertThat(result.getType()).isEqualTo(OPEN_CLOSE.OPEN);
    }

    @Test
    void apply_ShouldHandleEmptyValues() {
        PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO openingIntervalDTO =
                PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO.builder()
                        .start("")
                        .end("")
                        .type(null)
                        .build();

        OpeningInterval result = openingIntervalMapper.apply(openingIntervalDTO);

        assertThat(result.getStart()).isEmpty();
        assertThat(result.getEnd()).isEmpty();
        assertThat(result.getType()).isNull();
    }
}
