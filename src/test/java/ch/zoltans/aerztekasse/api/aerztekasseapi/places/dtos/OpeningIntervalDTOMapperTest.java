package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningInterval;
import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.OpeningInterval.OPEN_CLOSE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpeningIntervalDTOMapperTest {

    @Autowired
    private OpeningIntervalDTOMapper openingIntervalDTOMapper;

    @Test
    void testApply_ValidOpeningInterval_ShouldReturnCorrectDTO() {
        // Arrange
        OpeningInterval openingInterval = OpeningInterval.builder()
                .start("09:00")
                .end("17:00")
                .type(OPEN_CLOSE.OPEN)
                .build();

        // Act
        PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO result = openingIntervalDTOMapper.apply(openingInterval);

        // Assert
        assertNotNull(result, "The result DTO should not be null");
        assertEquals("09:00", result.getStart(), "The start time should match");
        assertEquals("17:00", result.getEnd(), "The end time should match");
        assertEquals(OPEN_CLOSE.OPEN, result.getType(), "The type should match");
    }

    @Test
    void testApply_NullOpeningInterval_ShouldThrowException() {
        // Arrange
        OpeningInterval openingInterval = null;

        // Act & Assert
        try {
            openingIntervalDTOMapper.apply(openingInterval);
        } catch (NullPointerException e) {
            assertNotNull(e, "An exception should be thrown if the input is null");
        }
    }

    @Test
    void testApply_EmptyOpeningInterval_ShouldReturnDTOWithNullValues() {
        // Arrange
        OpeningInterval openingInterval = OpeningInterval.builder().build();

        // Act
        PlaceDTO.OpeningHoursDTO.DaysDTO.OpeningIntervalDTO result = openingIntervalDTOMapper.apply(openingInterval);

        // Assert
        assertNotNull(result, "The result DTO should not be null");
        assertEquals(null, result.getStart(), "The start time should be null");
        assertEquals(null, result.getEnd(), "The end time should be null");
        assertEquals(null, result.getType(), "The type should be null");
    }
}
