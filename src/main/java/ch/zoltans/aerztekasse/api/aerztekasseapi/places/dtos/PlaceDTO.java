package ch.zoltans.aerztekasse.api.aerztekasseapi.places;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningHours;

public record PlaceDTO (
		String label,
		String location,
		OpeningHours openingHours,
		String dummyValue
) {

}
