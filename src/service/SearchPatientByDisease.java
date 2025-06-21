package service;

import java.util.List;
import java.util.Scanner;
import dao.PatientDAO;
import model.Patient;

public class SearchPatientByDisease {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO dao = new PatientDAO();

    public static void execute() {
        System.out.print("\nEnter Disease to search: ");
        String disease = sc.nextLine();

        List<Patient> list = dao.getPatientsByDisease(disease);

        if (list.isEmpty()) {
            System.out.println(" No patients found with disease: " + disease);
            return;
        }

        System.out.println("\n--- Patients Found ---");
        System.out.printf("%-4s %-15s %-4s %-8s %-15s %-12s\n", "ID", "Name", "Age", "Gender", "Disease", "Date");
        for (Patient p : list) {
            System.out.println(p);
        }
    }
}
