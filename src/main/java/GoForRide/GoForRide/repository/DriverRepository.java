package GoForRide.GoForRide.repository;


import GoForRide.GoForRide.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findByMobNo(String mobNo);
}
