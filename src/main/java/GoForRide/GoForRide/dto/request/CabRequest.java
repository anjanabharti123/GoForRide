package GoForRide.GoForRide.dto.request;


import GoForRide.GoForRide.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest {

    String company;

    String carModel;

    String cabNo;

    CarType carType;

    int numberOfSeats;

    double farePerKm;
}
