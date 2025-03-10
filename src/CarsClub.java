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

        System.out.println("Car added successfully to user ID " + targetOwner.getOwnerID());
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

        if (targetOwner.getCarForDrive() != null) {
            System.out.println("Currently test driving car " + targetOwner.getCarForDrive().getReg());
        } else {
            System.out.println("Currently test driving car: none");
        }

        ArrayList<Car> userCars = targetOwner.getCars();
        System.out.print("Owner name " + targetOwner.getName() + " with id " + targetOwner.getOwnerID() + ": " + " phone number " + targetOwner.getPhone());
        for (Car car : userCars) {
            System.out.println("\nCar make: " + car.getMake());
            System.out.println("Car model: " + car.getModel());
            System.out.println("Car year: " + car.getYear());
            System.out.println("Car mileage: " + car.getMileage());
        }
    }

    public void putCarForSale() {
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
        }

        System.out.println("Enter car registration number: ");
        String registration = scan.nextLine();

        ArrayList<Car> ownerCars = targetOwner.getCars();
        Car targetCar = null;

        for (Car car : ownerCars) {
            if (car.getReg().equals(registration)) {
                targetCar = car;
            }
        }

        if (targetCar == null) {
            System.out.println("Car ID " + targetOwner.getOwnerID() + " not found");
            return;
        }

        targetOwner.setCarForSale(targetCar);
        return;
    }

    public void testDriveCar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the ID of the owner who wishes to test drive car: ");
        int driverOwnerId = scan.nextInt();
        scan.nextLine();

        Owner driverOwner = null;
        for (Owner owner : owners) {
            if (owner.getOwnerID() == driverOwnerId) {
                driverOwner = owner;
            }
        }

        if (driverOwner == null) {
            System.out.println("Owner ID " + driverOwnerId + " not found");
            return;
        }

        System.out.println("Enter the ID of the owner who is providing the car for test drive");
        int sellerOwnerId = scan.nextInt();
        scan.nextLine();

        Owner sellerOwner = null;
        for (Owner owner : owners) {
            if (owner.getOwnerID() == sellerOwnerId) {
                sellerOwner = owner;
            }
        }

        if (sellerOwner == null) {
            System.out.println("Owner ID " + sellerOwnerId + " not found");
            return;
        }

        Car carForSale = sellerOwner.getCarForSale();
        if (carForSale == null) {
            System.out.println("Car ID " + sellerOwner.getOwnerID() + " not found");
            return;
        }

        driverOwner.setCarForDrive(carForSale);

        System.out.println("Car ID " + driverOwner.getOwnerID() + " added successfully");
    }
}
