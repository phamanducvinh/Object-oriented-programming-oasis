import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Vehicle> vehicleList = new ArrayList<>();
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * Remove .
     */
    public void removeVehicle(String registrationNumber) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.registrationNumber.equals(registrationNumber)) {
                vehicleList.remove(vehicle);
            }
        }
    }

    /**
     * Get info.
     */
    public String getVehiclesInfo() {
        if (vehicleList.size() == 0) {
            return name + " has no vehicle!";
        }

        String result = name + " has:" + "\n" + "\n";
        for (Vehicle vehicle : vehicleList) {
            result = result + vehicle.getInfo();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
    }
}
