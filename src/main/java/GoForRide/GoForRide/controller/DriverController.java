package GoForRide.GoForRide.controller;


import GoForRide.GoForRide.dto.request.DriverRequest;
import GoForRide.GoForRide.model.Driver;
import GoForRide.GoForRide.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest) {
        String response = driverService.addDriver(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/mob-no/{mob-no}")
    public Driver getDriver(@PathVariable("mob-no") String mobNo) {
        return driverService.getDriver(mobNo);
    }
}
