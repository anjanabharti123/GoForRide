package GoForRide.GoForRide.service;


import GoForRide.GoForRide.dto.request.TripBookingRequest;
import GoForRide.GoForRide.dto.response.TripBookingResponse;
import GoForRide.GoForRide.exception.CabNotAvailableException;
import GoForRide.GoForRide.exception.CustomerNotFoundException;
import GoForRide.GoForRide.model.Cab;
import GoForRide.GoForRide.model.Customer;
import GoForRide.GoForRide.model.TripBooking;
import GoForRide.GoForRide.repository.CabRepository;
import GoForRide.GoForRide.repository.CustomerRepository;
import GoForRide.GoForRide.repository.DriverRepository;
import GoForRide.GoForRide.repository.TripBookingRepository;
import GoForRide.GoForRide.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {

    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final TripBookingRepository tripBookingRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public TripBookingResponse bookCab(boolean applyCoupon,
                                       TripBookingRequest tripBookingRequest) {

        // validate email id of the customer
        Customer customer = customerRepository.findByEmailId(tripBookingRequest
                .getCustomerEmailId());

        if(customer == null) {
            throw new CustomerNotFoundException("Invalid email id");
        }

        // check if a cab is available or not for booking
        // get a random available cab
        Cab cab = cabRepository.getRandomAvailableCab();
        if(cab == null) {
            throw new CabNotAvailableException("Sorry! All drivers are busy right now!!");
        }

        // prepare the booking entity
        TripBooking tripBooking = BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerKm() * tripBookingRequest.getTripDistanceInKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        // save booking
        TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);

        customer.getBookings().add(savedTripBooking);
        cab.setAvailable(false);
        cab.getDriver().getBookings().add(savedTripBooking);

         // customer and booking
        customerRepository.save(customer); // customer + savedBooking
        driverRepository.save(cab.getDriver()); // driver + cab + savedBooking
        
        sendEmail(savedTripBooking);

        // last step -> prepare booking response
        return BookingTransformer.tripBookingToTripBookingResponse(savedTripBooking);

    }

    private void sendEmail(TripBooking savedTripBooking) {

        // prepare your email
        String text = "Congrats!! " + savedTripBooking.getCustomer().getName()
                + " your ride is booked with" + savedTripBooking.getDriver().getName();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("acciojobspring@gmail.com");
        simpleMailMessage.setTo(savedTripBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Cab Booked!!!");
        simpleMailMessage.setText(text);

        // send the email
        javaMailSender.send(simpleMailMessage);
    }
}
