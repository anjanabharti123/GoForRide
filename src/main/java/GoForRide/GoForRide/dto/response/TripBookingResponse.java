package GoForRide.GoForRide.dto.response;


import GoForRide.GoForRide.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBookingResponse {

    String bookingId;  // UUID

    String pickup;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    Date bookedAt;

    CustomerResponse customerResponse;

    DriverResponse driverResponse;

    String message;
}
