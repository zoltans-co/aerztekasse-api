package ch.zoltans.aerztekasse.api.aerztekasseapi.places.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJsonContent extends RuntimeException {
  public InvalidJsonContent(String message) {
    throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST, message, new RuntimeException(message));
  }
}
