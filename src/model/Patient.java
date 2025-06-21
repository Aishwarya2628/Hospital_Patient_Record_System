package model;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String admittedDate;

    // Constructor without ID (for insert)
    public Patient(String name, int age, String gender, String disease, String admittedDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.admittedDate = admittedDate;
    }

    // Constructor with ID (for fetch)
    public Patient(int id, String name, int age, String gender, String disease, String admittedDate) {
        this(name, age, gender, disease, admittedDate);
        this.id = id;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDisease() { return disease; }
    public String getAdmittedDate() { return admittedDate; }

    // For displaying patient in table format
    @Override
    public String toString() {
        return String.format("%-4d %-15s %-4d %-8s %-15s %-12s",
                id, name, age, gender, disease, admittedDate);
    }
}
