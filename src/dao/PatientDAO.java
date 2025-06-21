package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import model.Patient;
import util.DBConnection;

public class PatientDAO {
    public boolean addPatient(Patient p) {
        String sql = "INSERT INTO patients(name, age, gender, disease, admitted_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getDisease());
            ps.setDate(5, Date.valueOf(p.getAdmittedDate()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error adding patient: " + e.getMessage());
            return false;
        }
    }

    public int getPatientCount() {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM patients")) {
            if (rs.next()) return rs.getInt("total");
        } catch (Exception e) {
            System.out.println("Error getting count: " + e.getMessage());
        }
        return 0;
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY admitted_date DESC";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("disease"),
                    rs.getDate("admitted_date").toString()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        return list;
    }

    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("disease"),
                    rs.getDate("admitted_date").toString()
                );
            }
        } catch (Exception e) {
            System.out.println("Error searching patient: " + e.getMessage());
        }
        return null;
    }

    public List<Patient> getPatientsByDisease(String disease) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE disease LIKE ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + disease + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("disease"),
                    rs.getDate("admitted_date").toString()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error searching by disease: " + e.getMessage());
        }
        return list;
    }

    public boolean updateDisease(int id, String newDisease) {
        String sql = "UPDATE patients SET disease=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newDisease);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error updating disease: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error deleting patient: " + e.getMessage());
            return false;
        }
    }
}

