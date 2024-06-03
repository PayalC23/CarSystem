package CarSystem;

import java.time.LocalDate;

public class TestCar {

	public static void main(String[] args) {
		Car car1 = new Car("ABC123", "Toyota", "Crysta", -2019,true,"White");
        Car car2 = new Car("DEF456", "Hyndai", "Amaze", 2022,true,"Black");

        Customer customer1 = new Customer("CUST001", "Payal", "payal@gmail.com","123456");
        Customer customer2 = new Customer("CUST002", "Ruchita", "ruchitayahoo.com","6780012");

        Rental rental1 = new Rental(car1, customer1, LocalDate.now());
        Rental rental2 = new Rental(car2, customer2, LocalDate.now().minusDays(1));

        System.out.println("Rental 1: Car " + rental1.getCar().getLicensePlate()+" "+ rental1.getCar().getModel() +" "+ rental1.getCar().getColor() + " rented by " + rental1.getCustomer().getName());
        System.out.println("Rental 2: Car " + rental2.getCar().getLicensePlate() +" "+ rental2.getCustomer().getPhoneNumber()+" "+rental2.getCustomer().getEmail()+" rented by " + rental2.getCustomer().getName());

        try {
            rental1.returnCar(LocalDate.now().minusDays(1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        rental2.returnCar(LocalDate.now());
        System.out.println("Rental 2: Car " + rental2.getCar().getLicensePlate()+" "+ rental2.getReturnDate() + " returned");

        try {
            new Rental(car1, customer1, LocalDate.now().plusDays(1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
	}


