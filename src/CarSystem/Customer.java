package CarSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Car> rentedCars;

    public Customer(String customerId, String name, String email, String phoneNumber) {
        if (customerId == null || customerId.isEmpty()) {
        	System.out.println("Customer ID cannot be null or empty");
        }
        if (!email.contains("@")) {
        	System.out.println("Email must contain an @ symbol");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
        	System.out.println("Phone number cannot be null or empty");
        }
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber=phoneNumber;
        this.rentedCars = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void addRentedCar(Car car) {
        if (rentedCars.contains(car)) {
        	System.out.println("Customer has already rented this car");
        }
        rentedCars.add(car);
    }

    public void removeRentedCar(Car car) {
        rentedCars.remove(car);
    }
}


