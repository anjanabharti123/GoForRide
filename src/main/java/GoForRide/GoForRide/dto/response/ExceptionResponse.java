package GoForRide.GoForRide.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {

    String message;
    int statusCode;
}
