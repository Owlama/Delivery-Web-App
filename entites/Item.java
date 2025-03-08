package ng.com.nokt.demodelivery.entites;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double weight; // Added weight field

    private String code;

    public String getCode() {
        return code;
    }

    @ManyToOne
    @JoinColumn(name = "vehicle_id") // Foreign key in the Item table
    private Vehicle vehicle;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() { // Added getWeight() method
        return weight;
    }

    public void setWeight(double weight) { // Added setWeight() method
        this.weight = weight;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setCode(String generatedCode) {
    }
}