package util;

import java.util.Scanner;

public class Utils {
    static Scanner sc = new Scanner(System.in);

    public static int readValidAge() {
        int age;
        while (true) {
            System.out.print("Age: ");
            age = sc.nextInt();
            if (age > 0) break;
            System.out.println("❌ Age must be positive.");
        }
        return age;
    }

    public static String readValidGender() {
        sc.nextLine(); // clear buffer
        String gender;
        while (true) {
            System.out.print("Gender (Male/Female/Other): ");
            gender = sc.nextLine();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other"))
                break;
            System.out.println("❌ Invalid gender. Try again.");
        }
        return gender;
    }

    public static String readValidDate() {
        String date;
        while (true) {
            System.out.print("Admitted Date (yyyy-mm-dd): ");
            date = sc.nextLine();
            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) break;
            System.out.println("❌ Invalid date format. Try again.");
        }
        return date;
    }

    public static String readNonEmptyLine(String prompt) {
        String line;
        while (true) {
            System.out.print(prompt);
            line = sc.nextLine();
            if (!line.trim().isEmpty()) break;
            System.out.println("Input cannot be empty.");
        }
        return line;
    }
}

