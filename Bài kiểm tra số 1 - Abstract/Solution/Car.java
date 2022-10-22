public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructor.
     * */
    public Car(String brand,
               String model,
               String registrationNumber,
               Person owner,
               int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Get Info.
     */
    @Override
    public String getInfo() {
        String info = "Car:" + "\n";
        info = info + "\t" + "Brand: " + brand + "\n";
        info = info + "\t" + "Model: " + model + "\n";
        info = info + "\t" + "Registration Number: " + registrationNumber + "\n";
        info = info + "\t" + "Number of Doors: " + numberOfDoors + "\n";
        info = info + "\t" + "Belongs to " + owner.getName() + " - " + owner.getAddress() + "\n";
        return info;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
