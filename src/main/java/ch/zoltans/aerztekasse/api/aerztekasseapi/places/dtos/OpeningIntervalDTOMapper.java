package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningInterval;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OpeningIntervalDTOMapper implements Function<OpeningInterval, PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO> {
	
	@Override
	public PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO apply(OpeningInterval openingInterval) {
		return PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO.builder()
				.start(openingInterval.getStart())
				.end(openingInterval.getEnd())
				.type(openingInterval.getType())
				.build();
	}
	
}
