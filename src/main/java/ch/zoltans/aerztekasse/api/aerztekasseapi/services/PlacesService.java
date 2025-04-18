package ch.zoltans.aerztekasse.api.aerztekasseapi.services;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos.*;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Days;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningHours;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningInterval;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Place;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.exceptions.InvalidJsonContent;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.exceptions.NotFoundException;
import ch.zoltans.aerztekasse.api.aerztekasseapi.repositories.PlaceRepository;
import jakarta.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PlacesService {

  private final PlaceRepository placeRepository;

  private final OpeningIntervalMapper openingIntervalMapper;
  private final PlacesDTOMapper placesDTOMapper;

  @Transactional
  public Place createPlace(PlaceDTO placeDTO) {
    log.info("PlacesService createPlace was called with placeDTO: {}", placeDTO);
    try{
      return persistPlace(placeDTO);
    } catch (Exception e) {
      throw new InvalidJsonContent("Invalid JSON content. Exception:" + e + "'.");
    }
  }

  private Place persistPlace(PlaceDTO placeDTO) {
    log.info("PlacesService persistPlace was called with placeDTO: {}", placeDTO);

    List<OpeningInterval> monday =
        placeDTO.getOpening_hours().getDays().getMonday() != null
            ? placeDTO.getOpening_hours().getDays().getMonday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    List<OpeningInterval> tuesday =
        placeDTO.getOpening_hours().getDays().getTuesday() != null
            ? placeDTO.getOpening_hours().getDays().getTuesday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    List<OpeningInterval> wednesday =
        placeDTO.getOpening_hours().getDays().getWednesday() != null
            ? placeDTO.getOpening_hours().getDays().getWednesday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    List<OpeningInterval> thursday =
        placeDTO.getOpening_hours().getDays().getThursday() != null
            ? placeDTO.getOpening_hours().getDays().getThursday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    List<OpeningInterval> friday =
        placeDTO.getOpening_hours().getDays().getFriday() != null
            ? placeDTO.getOpening_hours().getDays().getFriday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    List<OpeningInterval> saturday =
        placeDTO.getOpening_hours().getDays().getSaturday() != null
            ? placeDTO.getOpening_hours().getDays().getSaturday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    List<OpeningInterval> sunday =
        placeDTO.getOpening_hours().getDays().getSunday() != null
            ? placeDTO.getOpening_hours().getDays().getSunday().stream()
                .map(openingIntervalMapper)
                .toList()
            : Collections.emptyList();

    Days days =
        Days.builder()
            .monday(monday)
            .tuesday(tuesday)
            .wednesday(wednesday)
            .thursday(thursday)
            .friday(friday)
            .saturday(saturday)
            .sunday(sunday)
            .build();

    OpeningHours openingHours = OpeningHours.builder().days(days).build();

    Place place =
        Place.builder()
            .label(placeDTO.getLabel())
            .location(placeDTO.getLocation())
            .openingHours(openingHours)
            .build();

    return placeRepository.save(place);
  }

  public PlacesDTO getAllPlacesDTO() {
    log.info("PlacesService getAllPlacesDTO was called.");
    List<Place> places = placeRepository.findAll();
    if (places.isEmpty()) {
      throw new NotFoundException("No places found.");
    }
    return PlacesDTO.builder().places(places.stream().map(placesDTOMapper).toList()).build();
  }

  @Transactional
  public void deletePlaceByLabel(String name) {
    log.info("PlacesService deletePlaceByLabel called with name: {}", name);

    // Retrieve the list of places filtered by the label
    List<Place> places = placeRepository.findAllByLabel(name);

    // Check if no places are found
    if (places.isEmpty()) {
      throw new NotFoundException("No places found with the name '" + name + "'.");
    }

    // Delete all matching places
    placeRepository.deleteAll(places);
    log.info("Deleted {} place(s) with the name '{}'.", places.size(), name);
  }
}
