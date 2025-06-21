package service;

import java.util.Scanner;
import dao.PatientDAO;

public class DeletePatient {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO dao = new PatientDAO();

    public static void execute() {
        System.out.print("\nEnter Patient ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear newline

        boolean deleted = dao.deletePatient(id);
        if (deleted) {
            System.out.println(" Patient deleted successfully.");
        } else {
            System.out.println("Delete failed. Patient not found.");
        }
    }
}
