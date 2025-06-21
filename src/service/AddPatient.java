

package service;

import java.util.Scanner;
import dao.PatientDAO;
import model.Patient;
import util.Utils;

public class AddPatient {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO dao = new PatientDAO();

    public static void execute() {
        System.out.println("\n--- Add New Patient ---");

        String name = Utils.readNonEmptyLine("Name: ");
        int age = Utils.readValidAge();
        String gender = Utils.readValidGender();

        System.out.print("Disease: ");
        String disease = sc.nextLine();

        String admittedDate = Utils.readValidDate();

        Patient patient = new Patient(name, age, gender, disease, admittedDate);

        if (dao.addPatient(patient)) {
            System.out.println("Patient added successfully!");
        } else {
            System.out.println(" Failed to add patient.");
        }
    }
}
