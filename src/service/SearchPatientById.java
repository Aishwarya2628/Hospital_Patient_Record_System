package service;

import java.util.Scanner;
import dao.PatientDAO;
import model.Patient;

public class SearchPatientById {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO dao = new PatientDAO();

    public static void execute() {
        System.out.print("\nEnter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear newline

        Patient p = dao.getPatientById(id);
        if (p != null) {
            System.out.println("\n--- Patient Found ---");
            System.out.printf("%-4s %-15s %-4s %-8s %-15s %-12s\n", "ID", "Name", "Age", "Gender", "Disease", "Date");
            System.out.println(p);
        } else {
            System.out.println("No patient found with ID " + id);
        }
    }
}
