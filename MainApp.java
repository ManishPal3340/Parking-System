package parkingSystem;


import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n🚗 Parking Management System 🚗");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    VehicleService.parkVehicle();
                    break;
                case 2:
                    VehicleService.removeVehicle();
                    break;
                case 3:
                    VehicleService.viewParkedVehicles();
                    break;
                case 4:
                    System.out.println("🙏 Thank You");
                    break;
                default:
                    System.out.println("❌ Invalid Choice");
            }

        } while (choice != 4);
    }
}
