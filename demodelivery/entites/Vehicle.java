package ng.com.nokt.demodelivery.entites; // Corrected package name

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String plateNumber;

    private String status;

    private String type;

    private float fuelCapacity;

    private float carryingWeight;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>(); // Assigned items

    // Default constructor
    public Vehicle() {
    }

    // Constructor without id
    public Vehicle(String name, String plateNumber, String status, String type, float fuelCapacity, float carryingWeight, List<Item> items) {
        this.name = name;
        this.plateNumber = plateNumber;
        this.status = status;
        this.type = type;
        this.fuelCapacity = fuelCapacity;
        this.carryingWeight = carryingWeight;
        this.items = items;
    }

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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getCarryingWeight() {
        return carryingWeight;
    }

    public void setCarryingWeight(float carryingWeight) {
        this.carryingWeight = carryingWeight;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                ", carryingWeight=" + carryingWeight +
                ", items=" + items +
                '}';
    }
}