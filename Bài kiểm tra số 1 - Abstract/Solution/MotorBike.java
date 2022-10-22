public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    /**
     * Constructor.
     * */
    public MotorBike(String brand,
                     String model,
                     String registrationNumber,
                     Person owner,
                     boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    /**
     * Get info.
     */
    @Override
    public String getInfo() {
        String info = "Motor Bike:" + "\n";
        info = info + "\t" + "Brand: " + brand + "\n";
        info = info + "\t" + "Model: " + model + "\n";
        info = info + "\t" + "Registration Number: " + registrationNumber + "\n";
        info = info + "\t" + "Has Side Car: " + hasSidecar + "\n";
        info = info + "\t" + "Belongs to " + owner.getName() + " - " + owner.getAddress() + "\n";
        return info;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
