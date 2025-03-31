package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Days;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningHours;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Place;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlacesDTOMapperTest {

  @Mock
  private OpeningIntervalDTOMapper openingIntervalDTOMapper;

  @InjectMocks
  private PlacesDTOMapper placesDTOMapper;

  public PlacesDTOMapperTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testApply_withEmptyOpeningHours_shouldMapToPlaceDTOWithEmptyDays() {
    // Arrange
    Days days = Days.builder()
        .monday(List.of())
        .tuesday(List.of())
        .wednesday(List.of())
        .thursday(List.of())
        .friday(List.of())
        .saturday(List.of())
        .sunday(List.of())
        .build();

    OpeningHours openingHours = OpeningHours.builder()
        .days(days)
        .build();

    Place place = Place.builder()
        .label("Empty Hours Place")
        .location("Empty Location")
        .openingHours(openingHours)
        .build();

    // Act
    PlaceDTO placeDTO = placesDTOMapper.apply(place);

    // Assert
    assertThat(placeDTO.getLabel()).isEqualTo("Empty Hours Place");
    assertThat(placeDTO.getLocation()).isEqualTo("Empty Location");
    assertThat(placeDTO.getOpening_hours().getDays().getMonday()).isEmpty();
    assertThat(placeDTO.getOpening_hours().getDays().getTuesday()).isEmpty();
    assertThat(placeDTO.getOpening_hours().getDays().getWednesday()).isEmpty();
    assertThat(placeDTO.getOpening_hours().getDays().getThursday()).isEmpty();
    assertThat(placeDTO.getOpening_hours().getDays().getFriday()).isEmpty();
    assertThat(placeDTO.getOpening_hours().getDays().getSaturday()).isEmpty();
    assertThat(placeDTO.getOpening_hours().getDays().getSunday()).isEmpty();
  }
}
