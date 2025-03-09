import java.util.ArrayList;

public class Owner {
    private int ownerID;
    private String name;
    private String phone;
    private Car carForSale;
    private Car carForDrive;
    private ArrayList<Car> cars;

    public Owner(int ownerID, String name, String phone) {
        this.ownerID = ownerID;
        this.name = name;
        this.phone = phone;
        this.carForDrive = null;
        this.carForSale = null;
        this.cars = new ArrayList<Car>();
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Car getCarForDrive() {
        return carForDrive;
    }

    public void setCarForDrive(Car carForDrive) {
        this.carForDrive = carForDrive;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public Car getCarForSale() {
        return carForSale;
    }

    public void setCarForSale(Car carForSale) {
        this.carForSale = carForSale;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
