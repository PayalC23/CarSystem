package CarSystem;

import java.time.LocalDate;

public class Rental {
	 private Car car;
	    private Customer customer;
	    private LocalDate rentalDate;
	    private LocalDate returnDate;

	    public Rental(Car car, Customer customer, LocalDate rentalDate) {
	        if (rentalDate.isAfter(LocalDate.now())) {
	            System.out.println("Rental date cannot be in the future");
	        }
	        this.car = car;
	        this.customer = customer;
	        this.rentalDate = rentalDate;
	        this.returnDate = null;
	        car.rentCar();
	        customer.addRentedCar(car);
	    }

	    public Car getCar() {
	        return car;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public LocalDate getRentalDate() {
	        return rentalDate;
	    }

	    public LocalDate getReturnDate() {
	        return returnDate;
	    }

	    public void returnCar(LocalDate returnDate) {
	        if (returnDate.isBefore(rentalDate)) {
	        	System.out.println("Return date must be after rental date");
	        }
	        this.returnDate = returnDate;
	        car.returnCar();
	        customer.removeRentedCar(car);
	    }
	    public void extendRentalPeriod(int numberOfDays) {
	        if (numberOfDays <= 0) {
	        	System.out.println("Number of days to extend rental period must be a positive number");
	        }
	        if (returnDate == null) {
	        	System.out.println("Cannot extend rental period before returning the car");
	        }
	        LocalDate newReturnDate = returnDate.plusDays(numberOfDays);
	        if (newReturnDate.isAfter(LocalDate.now().plusDays(30))) {
	        	System.out.println("Rental period cannot be extended beyond 30 days");
	        }
	        returnDate = newReturnDate;
	    }

		public static boolean contains(Rental rental) {
			// TODO Auto-generated method stub
			return false;
		}

		public static void remove(Rental rental) {
			// TODO Auto-generated method stub
			
		}
	    
	}


