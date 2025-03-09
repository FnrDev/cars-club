import java.util.ArrayList;
import java.util.Scanner;

public class CarsClub {
    private final ArrayList<Owner> owners;

    public CarsClub() {
        this.owners = new ArrayList<Owner>();
    }

    public void addOwner() {
        Scanner scan = new Scanner(System.in);
        int newOwnerId = 1;

        if (!owners.isEmpty()) {
            int highestId = 0;
            for (Owner owner : owners) {
                if (owner.getOwnerID() > highestId) {
                    highestId = owner.getOwnerID();
                }
            }

            newOwnerId = highestId + 1;
        }

        System.out.println("Enter owner name: ");
        String name = scan.nextLine();
        System.out.println("Enter owner phone: ");
        String phone = scan.nextLine();

        Owner owner = new Owner(newOwnerId, name, phone);

        owners.add(owner);

        System.out.println("Owner added successfully with ID " + newOwnerId);
    }

    public void addCar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the owner ID: ");
        int ownerID = scan.nextInt();
        scan.nextLine();

        Owner targetOwner = null;
        for (Owner owner : owners) {
            if (owner.getOwnerID() == ownerID) {
                targetOwner = owner;
                break;
            }
        }

        if (targetOwner == null) {
            System.out.println("Owner ID " + ownerID + " not found");
            return;
        }

        System.out.println("Enter car details for owner: " + targetOwner.getName());
        System.out.println("Enter car registration number: ");
        String registration = scan.nextLine();

        System.out.println("Enter car make: ");
        String make = scan.nextLine();

        System.out.println("Enter car model: ");
        String model = scan.nextLine();

        System.out.println("Enter car year: ");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter car mileage: ");
        int mileage = scan.nextInt();
        scan.nextLine();

        Car newCar = new Car(registration, make, model, year, mileage);

        targetOwner.addCar(newCar);

        System.out.println("Car added successfully with ID " + targetOwner.getOwnerID());
    }

    public void listOwnersCars() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the owner ID: ");
        int ownerID = scan.nextInt();
        scan.nextLine();

        Owner targetOwner = null;
        for (Owner owner : owners) {
            if (owner.getOwnerID() == ownerID) {
                targetOwner = owner;
            }
        }

        if (targetOwner == null) {
            System.out.println("Owner ID " + ownerID + " not found");
            return;
        }

        ArrayList<Car> userCars = targetOwner.getCars();
        for (Car car : userCars) {
            System.out.println("Car make" + car.getMake());
            System.out.println("Car model" + car.getModel());
            System.out.println("Car year" + car.getYear());
            System.out.println("Car mileage" + car.getMileage());
        }
    }

    public void putCarForSale() {
        System.out.println("Putting car for sale");
    }

    public void testDriveCar() {
        System.out.println("Testing drive car");
    }
}
