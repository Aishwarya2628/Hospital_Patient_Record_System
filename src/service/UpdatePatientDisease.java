package service;

import java.util.Scanner;
import dao.PatientDAO;

public class UpdatePatientDisease {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO dao = new PatientDAO();

    public static void execute() {
        System.out.print("\nEnter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter new Disease: ");
        String disease = sc.nextLine();

        boolean updated = dao.updateDisease(id, disease);
        if (updated) {
            System.out.println("Disease updated successfully.");
        } else {
            System.out.println("Update failed. Patient not found.");
        }
    }
}
