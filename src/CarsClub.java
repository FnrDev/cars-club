import java.util.ArrayList;

public class CarsClub {
    private ArrayList<Owner> owners;

    public CarsClub() {
        this.owners = new ArrayList<Owner>();
    }

    public void addOwner() {
        System.out.println("Adding owner to the club");
    }

    public void addCar() {
        System.out.println("Adding car to the club");
    }

    public void listOwnersCars() {
        System.out.println("Listing owner cars");
    }

    public void putCarForSale() {
        System.out.println("Putting car for sale");
    }

    public void testDriveCar() {
        System.out.println("Testing drive car");
    }
}
