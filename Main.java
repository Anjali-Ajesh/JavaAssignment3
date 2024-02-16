package Assignment3;

import java.util.Scanner;
public class Main {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update/Edit Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByPRN();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    searchByPosition();
                    break;
                case 6:
                    updateStudent();
                    break;
                case 7:
                    deleteStudent();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);
    }

    private static void addStudent() {
        if (studentCount < MAX_STUDENTS) {
            System.out.print("Enter PRN: ");
            int prn = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Date of Birth: ");
            String dob = scanner.nextLine();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            students[studentCount++] = new Student(prn, name, dob, marks);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Maximum number of students reached. Cannot add more students.");
        }
    }

    private static void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of Students:");
            for (int i = 0; i < studentCount; i++) {
                System.out.println((i + 1) + ". " + students[i]);
            }
        }
    }

    private static void searchByPRN() {
        System.out.print("Enter PRN to search: ");
        int prn = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getPrn() == prn) {
                System.out.println("Student found: " + students[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }

    private static void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Student found: " + students[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with name " + name + " not found.");
        }
    }

    private static void searchByPosition() {
        System.out.print("Enter position (1 to " + studentCount + ") to search: ");
        int position = scanner.nextInt();
        if (position >= 1 && position <= studentCount) {
            System.out.println("Student at position " + position + ": " + students[position - 1]);
        } else {
            System.out.println("Invalid position. Please enter a number between 1 and " + studentCount + ".");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter PRN of student to update: ");
        int prn = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getPrn() == prn) {
                System.out.println("Enter updated details:");
                System.out.print("New PRN: ");
                students[i] = new Student(scanner.nextInt(), students[i].getName(), students[i].getDob(), students[i].getMarks());
                scanner.nextLine(); // consume newline
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter PRN of student to delete: ");
        int prn = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getPrn() == prn) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                studentCount--;
                System.out.println("Student with PRN " + prn + " deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }
}