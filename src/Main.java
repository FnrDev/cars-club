import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarsClub carsClub = new CarsClub();
        boolean finish = false;
        int menuChoice = 0;

        do {
            System.out.println("Please choose an option from the following menu:"
                    + "\n1. Add Owner to the system"
                    + "\n2. Add car to Owners list of cars"
                    + "\n3. List an owners cars"
                    + "\n4. Set car for sale"
                    + "\n5. Organise a test drive of a car"
                    + "\n6. Exit");

            menuChoice = input.nextInt();

            if (menuChoice == 1) {
                carsClub.addOwner();
            } else if (menuChoice == 2) {
                carsClub.addCar();
            } else if (menuChoice == 3) {
                carsClub.listOwnersCars();
            } else if (menuChoice == 4) {
                carsClub.putCarForSale();
            } else if (menuChoice == 5) {
                carsClub.testDriveCar();
            } else if (menuChoice == 6) {
                finish = true;
            }

        } while (!finish);
    }
}