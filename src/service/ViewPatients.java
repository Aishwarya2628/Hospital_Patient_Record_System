package service;

import java.util.List;
import dao.PatientDAO;
import model.Patient;

public class ViewPatients {
    private static final PatientDAO dao = new PatientDAO();

    public static void execute() {
        System.out.println("\n--- All Patients ---");

        List<Patient> list = dao.getAllPatients();

        if (list.isEmpty()) {
            System.out.println(" No patients found.");
            return;
        }

        System.out.printf("%-4s %-15s %-4s %-8s %-15s %-12s\n", "ID", "Name", "Age", "Gender", "Disease", "Date");
        for (Patient p : list) {
            System.out.println(p);
        }
    }
}

