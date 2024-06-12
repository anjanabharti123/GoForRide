package GoForRide.GoForRide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    String panNumber;

    @Column(unique = true, nullable = false)
    String mobNo;

    double rating;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    Cab cab;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    List<TripBooking> bookings = new ArrayList<>();
}
