import java.util.Scanner;
import dao.PatientDAO;
import service.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO dao = new PatientDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=======================================");
            System.out.println(" HOSPITAL PATIENT RECORD SYSTEM");
            System.out.println("Total Patients: " + dao.getPatientCount());
            System.out.println("=======================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Search Patients by Disease");
            System.out.println("5. Update Patient Disease");
            System.out.println("6. Delete Patient");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> AddPatient.execute();
                case 2 -> ViewPatients.execute();
                case 3 -> SearchPatientById.execute();
                case 4 -> SearchPatientByDisease.execute();
                case 5 -> UpdatePatientDisease.execute();
                case 6 -> DeletePatient.execute();
                case 7 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
