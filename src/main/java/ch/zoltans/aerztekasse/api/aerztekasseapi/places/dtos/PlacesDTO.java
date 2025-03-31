package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlacesDTO {

  List<PlaceDTO> places;
}
