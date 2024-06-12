package GoForRide.GoForRide.model;
import GoForRide.GoForRide.Enum.TripStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId;  // UUID

    String pickup;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    @CreationTimestamp
    Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
