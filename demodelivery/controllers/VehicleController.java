package ng.com.nokt.demodelivery.controllers;

import ng.com.nokt.demodelivery.entites.Item;
import ng.com.nokt.demodelivery.entites.Vehicle;
import ng.com.nokt.demodelivery.services.ItemService;
import ng.com.nokt.demodelivery.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicles")
@CrossOrigin(origins = "http://localhost:63342")
public class VehicleController {

    private final ItemService itemService;
    private final VehicleService vehicleService;

    public VehicleController(ItemService itemService, VehicleService vehicleService) {
        this.itemService = itemService;
        this.vehicleService = vehicleService;
    }

    /**
     * Create a new vehicle
     */
    @PostMapping("/create")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    /**
     * Get vehicle details by plate number
     */
    @GetMapping("/{plateNumber}")
    public ResponseEntity<Vehicle> getVehicleByPlateNumber(@PathVariable String plateNumber) {
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        return ResponseEntity.ok(vehicle);
    }

    /**
     * Add an item to a vehicle
     */
    @PostMapping("/{plateNumber}/items/{itemId}")
    public ResponseEntity<?> addItemToVehicle(@PathVariable String plateNumber, @PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);

        double weightOnVehicle = vehicle.getItems().stream().mapToDouble(Item::getWeight).sum();

        if ((weightOnVehicle + item.getWeight()) <= vehicle.getCarryingWeight()) {
            vehicle.getItems().add(item);
            vehicleService.createVehicle(vehicle);
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.badRequest().body("Too much weight for this vehicle");
        }
    }
}

