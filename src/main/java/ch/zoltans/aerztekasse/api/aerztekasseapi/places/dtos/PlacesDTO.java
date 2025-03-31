package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.enums.OPEN_CLOSE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
	
	PlacesDTO places;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PlacesDTO {
		
		private String label;
		private String location;
		private OpeningHoursDTO openingHours;
		
		@Data
		@Builder
		@NoArgsConstructor
		@AllArgsConstructor
		public static class OpeningHoursDTO {
			
			private DaysDTO days;
			
			@Data
			@Builder
			@NoArgsConstructor
			@AllArgsConstructor
			public static class DaysDTO {
				
				List<TimeIntervalsDTO> monday;
				List<TimeIntervalsDTO> tuesday;
				List<TimeIntervalsDTO> wednesday;
				List<TimeIntervalsDTO> thursday;
				List<TimeIntervalsDTO> friday;
				List<TimeIntervalsDTO> saturday;
				List<TimeIntervalsDTO> sunday;
				
				@Data
				@Builder
				@NoArgsConstructor
				@AllArgsConstructor
				public static class TimeIntervalsDTO {
					private String start;
					private String end;
					private OPEN_CLOSE type;
				}
			}
		}
	}
}
