package leoguedex.com.github.HealthCoachWeb.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class ApiException extends RuntimeException {

  @Getter
  private final HttpStatus httpStatus;
  
  public ApiException(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public ApiException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }
}
