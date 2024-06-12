package GoForRide.GoForRide.controller;


import GoForRide.GoForRide.Enum.Gender;
import GoForRide.GoForRide.dto.request.CustomerRequest;
import GoForRide.GoForRide.dto.response.CustomerResponse;
import GoForRide.GoForRide.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    // constructor injection
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse response = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // get all customers of a particular gender and above particular age

    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<List<CustomerResponse>> getCustomerByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender, @PathVariable("age") int age) {
        List<CustomerResponse> customerResponses = customerService.getCustomerByGenderAndAgeGreaterThan(gender,age);
        return new ResponseEntity<>(customerResponses,HttpStatus.FOUND);
    }

}
