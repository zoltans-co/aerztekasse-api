package ch.zoltans.aerztekasse.api.aerztekasseapi.controllers;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos.PlaceDTO;
import ch.zoltans.aerztekasse.api.aerztekasseapi.repositories.PlaceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlacesControllerE2ETest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@BeforeEach
	void setup() {
		placeRepository.deleteAll(); // Clean database before each test
	}
	
	@AfterEach
	void tearDown() {
		placeRepository.deleteAll(); // Clean database after each test
	}
	
	@Test
	void createPlace_shouldPersistPlaceSuccessfully() {
		// Arrange: Create a PlaceDTO payload
		PlaceDTO request = PlaceDTO.builder()
				.label("Test Place")
				.location("Test Location")
				.build();
		
		// Act: Call the POST /places endpoint
		// ResponseEntity<Place> response = restTemplate.postForEntity("/places", request, Place.class);
		
		// Assert: Verify that the place is saved and response is correct
		// assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
}

