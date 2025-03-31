package ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.enums.OPEN_CLOSE;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "OpeningInterval")
public class OpeningInterval {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long openingIntervalId;

  @Schema(
      description = "The start time of the opening interval, formatted as HH:mm",
      example = "11:30")
  private String start;

  @Schema(
      description = "The end time of the opening interval, formatted as HH:mm",
      example = "18:30")
  private String end;

  @Schema(description = "The type of the interval", example = "OPEN or CLOSE")
  private OPEN_CLOSE type;
}
