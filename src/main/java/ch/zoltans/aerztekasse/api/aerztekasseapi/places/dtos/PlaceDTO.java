package ch.zoltans.aerztekasse.api.aerztekasseapi.places.dtos;

import ch.zoltans.aerztekasse.api.aerztekasseapi.places.enums.OPEN_CLOSE;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {

  private String label;
  private String location;
  private OpeningHoursDTO opening_hours;

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

      List<OpeningIntervalDTO> monday;
      List<OpeningIntervalDTO> tuesday;
      List<OpeningIntervalDTO> wednesday;
      List<OpeningIntervalDTO> thursday;
      List<OpeningIntervalDTO> friday;
      List<OpeningIntervalDTO> saturday;
      List<OpeningIntervalDTO> sunday;

      @Data
      @Builder
      @NoArgsConstructor
      @AllArgsConstructor
      public static class OpeningIntervalDTO {
        private String start;
        private String end;
        private OPEN_CLOSE type;
      }
    }
  }
}
