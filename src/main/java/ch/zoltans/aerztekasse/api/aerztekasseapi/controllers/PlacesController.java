package ch.zoltans.aerztekasse.api.aerztekasseapi.places;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos.PlaceDTO;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Place;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/places")
@Tag(name = "Places", description = "The places API")
public class PlacesController {
	
	private final PlacesService placesService;
	
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "201", description = "Place created successfully."),
					@ApiResponse(responseCode = "400", description = "Invalid input.",
							content = @Content(schema = @Schema(implementation = Void.class)))
			})
	@Operation(summary = "Create a new place", description = "Add a new place and persist it in the database")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Place createPlace(@RequestBody PlaceDTO placeDTO) {
		return placesService.createPlace(placeDTO);
	}
	
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Places retrieved successfully."),
					@ApiResponse(responseCode = "404", description = "No places found.")
			})
	@Operation(summary = "Get all places", description = "Get all existing places")
	@GetMapping(path = "/")
	public List<Place> getAllPlaces() {
		return placesService.getAllPlaces();
	}
	
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "Place deleted successfully."),
					@ApiResponse(responseCode = "404", description = "Place not found.")
			}
	)
	@Operation(summary = "Delete place by name", description = "Delete a place by its name")
	@DeleteMapping(path = "/{name}")
	public ResponseEntity<String> deletePlaceByName(@PathVariable String name) {
		placesService.deletePlaceByLabel(name);
		return ResponseEntity.ok("Place with name '" + name + "' has been deleted successfully.");
	}
	
}
