package GoForRide.GoForRide.repository;


import GoForRide.GoForRide.Enum.Gender;
import GoForRide.GoForRide.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


//    @Query(value = "select * from customer_info where gender = :g and age_value >= :age",nativeQuery = true)
//    List<Customer> getByGenderAndAgeGreaterThan(String g, int age);

    @Query(value = "select c from Customer c where c.gender = :g and c.age >= :age")
    List<Customer> getByGenderAndAgeGreaterThan(Gender g, int age);

    Customer findByEmailId(String emailId);
}
