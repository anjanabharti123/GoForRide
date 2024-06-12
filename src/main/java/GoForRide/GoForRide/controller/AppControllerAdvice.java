package GoForRide.GoForRide.controller;


import GoForRide.GoForRide.dto.response.TripBookingResponse;
import GoForRide.GoForRide.exception.CabNotAvailableException;
import GoForRide.GoForRide.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppControllerAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({CustomerNotFoundException.class,
            CabNotAvailableException.class})
    public ResponseEntity<TripBookingResponse> handleException(Exception ex){
        TripBookingResponse response = TripBookingResponse.builder()
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
