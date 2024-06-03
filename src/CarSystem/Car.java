package CarSystem;

public class Car {
	private String licensePlate;
    private String model;
    private String brand;
    private int year;
    private boolean available;
    private String color;

    public Car(String licensePlate, String model, String brand, int year, boolean available,String color) {
        if (licensePlate == null || licensePlate.isEmpty()) {
            System.out.println("License plate cannot be null or empty");
        }
        if (year <= 0) {
        	System.out.println("Year must be a positive number");
        }
        if (color == null || color.isEmpty()) {
        	System.out.println("Color cannot be null or empty");
        }
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.available = available;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }
    public String getColor() {
        return color;
    }
    public void rentCar() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }
    
}
