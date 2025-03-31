package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningInterval;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OpeningIntervalMapper
    implements Function<PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO, OpeningInterval> {

	@Override
	public OpeningInterval apply(PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO openingIntervalDTO) {
    return OpeningInterval.builder()
		    .start(openingIntervalDTO.getStart())
		    .end(openingIntervalDTO.getEnd())
		    .type(openingIntervalDTO.getType())
        .build();
	}
	
}
