package GoForRide.GoForRide.service;


import GoForRide.GoForRide.Enum.Gender;
import GoForRide.GoForRide.dto.request.CustomerRequest;
import GoForRide.GoForRide.dto.response.CustomerResponse;
import GoForRide.GoForRide.model.Customer;
import GoForRide.GoForRide.repository.CustomerRepository;
import GoForRide.GoForRide.transformer.CustomerTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        // save the customer
        Customer savedCustomer = customerRepository.save(customer);
        // entity -> response dto
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getByGenderAndAgeGreaterThan(gender,age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
