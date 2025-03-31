package ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Place")
public class Place {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long placeId;

  @Column(nullable = false)
  private String label;
  
  @Column(nullable = false)
  private String location;

  @JsonManagedReference
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "openingHoursId", referencedColumnName = "openingHoursId")
  private OpeningHours openingHours;
}
