package CarSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RenatlAgency {
	private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

   
    

    public Car addCar(String licensePlate, String model, String brand, int year, String color) {
        Car car = new Car(licensePlate, model, brand, year, true,color);
        cars.add(car);
        return car;
    }

    public Customer addCustomer(String customerId, String name, String email, String phoneNumber) {
        Customer customer = new Customer(customerId, name, email, phoneNumber);
        customers.add(customer);
        return customer;
    }

    public Rental rentCar(Car car, Customer customer, LocalDate rentalDate) {
        if (!cars.contains(car)) {
        	System.out.println("Car not found in the agency");
        }
        if (!customers.contains(customer)) {
        	System.out.println("Customer not found in the agency");
        }
        Rental rental = new Rental(car, customer, rentalDate);
        rentals.add(rental);
        car.rentCar();
        customer.addRentedCar(car);
        return rental;
    }

    public void returnCar(Rental rental) {
        if (!Rental.contains(rental)) {
        	System.out.println("Rental not found in the agency");
        }
        rental.getCar().returnCar();
        rental.getCustomer().removeRentedCar(rental.getCar());
        Rental.remove(rental);
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(Car::isAvailable).collect(Collectors.toList());
    }

    public List<Car> getRentedCars() {
        return cars.stream().filter(car -> !car.isAvailable()).collect(Collectors.toList());
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}


