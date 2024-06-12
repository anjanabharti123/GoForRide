package GoForRide.GoForRide.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverResponse {

    String name;

    double rating;

    String mobNo;

    CabResponse cabResponse;
}
