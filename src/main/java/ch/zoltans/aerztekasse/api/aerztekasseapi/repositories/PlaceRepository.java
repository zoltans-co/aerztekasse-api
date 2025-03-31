package ch.zoltans.aerztekasse.api.aerztekasseapi.repositories;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

  List<Place> findAllByLabel(String name);
}
