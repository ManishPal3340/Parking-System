package parkingSystem;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ParkingService {

    public static int getAvailableSlot() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT slot_id FROM parking_slots WHERE status='AVAILABLE' LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("slot_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void updateSlotStatus(int slotId, String status) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE parking_slots SET status=? WHERE slot_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, slotId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
