package GoForRide.GoForRide.transformer;


import GoForRide.GoForRide.dto.request.CustomerRequest;
import GoForRide.GoForRide.dto.response.CustomerResponse;
import GoForRide.GoForRide.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .address(customerRequest.getAddress())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .build();
    }
}
