import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String studentName;
    private String courseDepartment;
    private int semester;
    public Student(String studentId, String studentName, String courseDepartment, int semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseDepartment = courseDepartment;
        this.semester = semester;
    }
    public String getStudentId() {
        return studentId;
    public String getStudentName() {
        return studentName;
    }
    public String getCourseDepartment() {
        return courseDepartment;
    }
    public int getSemester() {
        return semester;
    }
    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + studentName + 
               " | Department: " + courseDepartment + " | Semester: " + semester;
    }
}

public class Program10 {
    private static ArrayList<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("a. Add Student");
            System.out.println("b. Remove Student");
            System.out.println("c. Search Student");
            System.out.println("d. Display All Students");
            System.out.println("e. Exit");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine().trim();

            switch (choice.toLowerCase()) {
                case "a":
                    addStudent(scanner);
                    break;
                case "b":
                    removeStudent(scanner);
                    break;
                case "c":
                    searchStudent(scanner);
                    break;
                case "d":
                    displayAllStudents();
                    break;
                case "e":
                    System.out.println("Exiting Student Record Management System.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("Error: Student ID " + id + " already exists!");
                return;
            }
        }
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Course/Department: ");
        String dept = scanner.nextLine().trim();
        System.out.print("Enter Semester: ");
        int semester = Integer.parseInt(scanner.nextLine().trim());
        Student student = new Student(id, name, dept, semester);
        studentList.add(student);
        System.out.println("Student record added successfully.");
    }
    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId().equalsIgnoreCase(id)) {
                studentList.remove(i);
                System.out.println("Student record removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student record not found.");
        }
    }
    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID or Student Name to search: ");
        String query = scanner.nextLine().trim();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(query) || s.getStudentName().equalsIgnoreCase(query)) {
                System.out.println("Student Details: " + s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student record not found.");
        }
    }
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("\nAll Student Records");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }
}