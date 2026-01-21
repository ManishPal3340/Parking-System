package parkingSystem;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class VehicleService {

    public static void parkVehicle() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Vehicle Number: ");
            String vehicleNo = sc.nextLine();

            int slotId = ParkingService.getAvailableSlot();

            if (slotId == -1) {
                System.out.println("❌ No Parking Slot Available");
                return;
            }

            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO vehicles(vehicle_no, slot_id) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vehicleNo);
            ps.setInt(2, slotId);
            ps.executeUpdate();

            ParkingService.updateSlotStatus(slotId, "OCCUPIED");

            System.out.println("✅ Vehicle Parked at Slot: " + slotId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeVehicle() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Vehicle Number: ");
            String vehicleNo = sc.nextLine();

            Connection con = DBConnection.getConnection();

            String selectSql = "SELECT slot_id FROM vehicles WHERE vehicle_no=? AND exit_time IS NULL";
            PreparedStatement ps1 = con.prepareStatement(selectSql);
            ps1.setString(1, vehicleNo);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("❌ Vehicle Not Found");
                return;
            }

            int slotId = rs.getInt("slot_id");

            String updateSql = "UPDATE vehicles SET exit_time=NOW() WHERE vehicle_no=?";
            PreparedStatement ps2 = con.prepareStatement(updateSql);
            ps2.setString(1, vehicleNo);
            ps2.executeUpdate();

            ParkingService.updateSlotStatus(slotId, "AVAILABLE");

            System.out.println("✅ Vehicle Removed. Slot Free: " + slotId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewParkedVehicles() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM vehicles WHERE exit_time IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n🚗 Parked Vehicles");
            while (rs.next()) {
                System.out.println(
                    "Vehicle No: " + rs.getString("vehicle_no") +
                    ", Slot: " + rs.getInt("slot_id") +
                    ", Entry: " + rs.getTimestamp("entry_time")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
