package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Place;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class PlacesDTOMapper implements Function<Place, PlaceDTO> {

  private final OpeningIntervalDTOMapper openingIntervalDTOMapper;

  public PlacesDTOMapper(OpeningIntervalDTOMapper openingIntervalDTOMapper) {
    this.openingIntervalDTOMapper = openingIntervalDTOMapper;
  }

  @Override
  public PlaceDTO apply(Place place) {
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> mondayOpeningIntervals =
        !place.getOpeningHours().getDays().getMonday().isEmpty()
            ? place.getOpeningHours().getDays().getMonday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> tuesdayOpeningIntervals =
        !place.getOpeningHours().getDays().getTuesday().isEmpty()
            ? place.getOpeningHours().getDays().getTuesday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> wednesdayOpeningIntervals =
        !place.getOpeningHours().getDays().getWednesday().isEmpty()
            ? place.getOpeningHours().getDays().getWednesday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> thursdayOpeningIntervals =
        !place.getOpeningHours().getDays().getThursday().isEmpty()
            ? place.getOpeningHours().getDays().getThursday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> fridayOpeningIntervals =
        !place.getOpeningHours().getDays().getFriday().isEmpty()
            ? place.getOpeningHours().getDays().getFriday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> saturdayOpeningIntervals =
        !place.getOpeningHours().getDays().getSaturday().isEmpty()
            ? place.getOpeningHours().getDays().getSaturday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();
    List<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> sundayOpeningIntervals =
        !place.getOpeningHours().getDays().getSunday().isEmpty()
            ? place.getOpeningHours().getDays().getSunday().stream()
                .map(openingIntervalDTOMapper)
                .toList()
            : Collections.emptyList();

    PlaceDTO.OpeningHoursDTO.DaysDTO daysDTO =
        PlaceDTO.OpeningHoursDTO.DaysDTO.builder()
            .monday(mondayOpeningIntervals)
            .tuesday(tuesdayOpeningIntervals)
            .wednesday(wednesdayOpeningIntervals)
            .thursday(thursdayOpeningIntervals)
            .friday(fridayOpeningIntervals)
            .saturday(saturdayOpeningIntervals)
            .sunday(sundayOpeningIntervals)
            .build();

    PlaceDTO.OpeningHoursDTO openingHoursDTO =
        PlaceDTO.OpeningHoursDTO.builder().days(daysDTO).build();

    return PlaceDTO.builder()
        .label(place.getLabel())
        .location(place.getLocation())
        .opening_hours(openingHoursDTO)
        .build();
  }
}
