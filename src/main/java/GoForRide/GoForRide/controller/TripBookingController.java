package GoForRide.GoForRide.controller;


import GoForRide.GoForRide.dto.request.TripBookingRequest;
import GoForRide.GoForRide.dto.response.TripBookingResponse;
import GoForRide.GoForRide.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trip")
@RequiredArgsConstructor
public class TripBookingController {

    private final TripBookingService tripBookingService;

    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "apply-coupon",
            required = false, defaultValue = "false") boolean applyCoupon,
                                                       @RequestBody TripBookingRequest tripBookingRequest) {
        TripBookingResponse response = tripBookingService.bookCab(applyCoupon,tripBookingRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
