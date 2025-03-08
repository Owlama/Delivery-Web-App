package ng.com.nokt.demodelivery.controllers;

import ng.com.nokt.demodelivery.services.VehicleService;
import org.springframework.stereotype.Controller;
import java.util.List;
import ng.com.nokt.demodelivery.entites.Vehicle;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PageController {
    @Controller
    public class pageController {

        @GetMapping("/index")
        public String homePage() {
            return "index";
        }

        @GetMapping("/about")
        public String aboutPage() {
            return "about";
        }

        @GetMapping("/feature")
        public String featurePage(Model model) {
            VehicleService vehicleService = null;
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            model.addAttribute("vehicles", vehicles);
            return "feature";
        }

        @GetMapping("/add-item")
        public String addItemPage() {
            return "add-item";
        }
    }

}
