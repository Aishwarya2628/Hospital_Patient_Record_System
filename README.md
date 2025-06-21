# 🏥 Hospital Patient Record System

This is a Java-based console application to manage hospital patient records. It uses **JDBC** to connect with a **MySQL database**, supporting basic CRUD operations like:

- Add
- View
- Search (by ID & Disease)
- Update
- Delete

---

## 🚀 Features

- Add new patient details
- View all patients
- Search patient by ID
- Search patients by disease
- Update disease of a patient
- Delete a patient record

---

## 🛠️ Tech Stack

- Java (JDK 17+)
- JDBC (MySQL Connector/J)
- MySQL (Localhost)
- Console UI

---

## 🗂️ Project Structure

```

Hospital\_Patient\_Record\_System/
├── bin/                     # Compiled class files
├── lib/                     # MySQL Connector JAR
├── src/
│   ├── dao/                 # Data access layer
│   ├── service/             # Feature logic
│   ├── util/                # DB connection utilities
│   └── Main.java            # Entry point
├── .gitignore
├── sources.txt
└── README.md

````

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Hospital_Patient_Record_System.git
cd Hospital_Patient_Record_System
````

### 2. Add MySQL Connector

* Download from: [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)
* Place the `.jar` file inside the `lib/` folder
* Rename it to: `mysql-connector-j-9.3.0.jar`

### 3. Compile the Java Files

```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
javac -encoding UTF-8 -cp "lib/mysql-connector-j-9.3.0.jar" -d bin @(Get-Content sources.txt)
```

### 4. Run the Application

```bash
java -cp "bin;lib/mysql-connector-j-9.3.0.jar" Main
```

---

## 🛢️ MySQL Setup

```sql
CREATE DATABASE hospitalManagement;
USE hospitalManagement;

CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL CHECK (age > 0),
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    disease VARCHAR(100) NOT NULL,
    admitted_date DATE NOT NULL
);
```

---

## 📸 Sample Output

```
=======================================
🏥 HOSPITAL PATIENT RECORD SYSTEM
Total Patients: 2
=======================================
1. Add Patient
2. View All Patients
3. Search Patient by ID
4. Search Patients by Disease
5. Update Patient Disease
6. Delete Patient
7. Exit
Enter your choice: 1

--- Add New Patient ---
Name: Priya
Age: 25
Gender (Male/Female/Other): Female
Disease: Fever
Admitted Date (yyyy-mm-dd): 2025-06-20
✅ Patient added successfully!

=======================================
🏥 HOSPITAL PATIENT RECORD SYSTEM
Total Patients: 3
=======================================
Enter your choice: 2

--- All Patients ---
ID: 1 | Name: Aish | Age: 21 | Gender: Female | Disease: Cold | Admitted: 2025-06-10
ID: 2 | Name: Raj  | Age: 30 | Gender: Male   | Disease: Fever | Admitted: 2025-06-19
ID: 3 | Name: Priya| Age: 25 | Gender: Female | Disease: Fever | Admitted: 2025-06-20

Enter your choice: 3
Enter Patient ID to search: 2
✅ Patient Found!
ID: 2 | Name: Raj | Age: 30 | Gender: Male | Disease: Fever | Admitted: 2025-06-19

Enter your choice: 4
Enter disease to search: Fever
✅ Patients with disease 'Fever':
ID: 2 | Name: Raj | Age: 30 | Gender: Male | Admitted: 2025-06-19
ID: 3 | Name: Priya | Age: 25 | Gender: Female | Admitted: 2025-06-20

Enter your choice: 5
Enter Patient ID to update: 1
Enter new disease: Asthma
✅ Patient disease updated successfully!

Enter your choice: 6
Enter Patient ID to delete: 2
✅ Patient deleted successfully!

Enter your choice: 2

--- All Patients ---
ID: 1 | Name: Aish | Age: 21 | Gender: Female | Disease: Asthma | Admitted: 2025-06-10
ID: 3 | Name: Priya | Age: 25 | Gender: Female | Disease: Fever | Admitted: 2025-06-20

Enter your choice: 7
👋 Exiting... Thank you!
```

---

## 🙋‍♀️ Developed By

**Aishwarya K**

---

## 📃 License

This project is open-source and free to use for educational purposes.


