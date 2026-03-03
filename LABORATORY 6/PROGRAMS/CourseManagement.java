import java.util.*;

public class CourseManagement {

    static ArrayList<String> courses = new ArrayList<>();
    static HashMap<String, ArrayList<String>> enrollments = new HashMap<>();

    public static void addCourse(String courseName) {
        if (!courses.contains(courseName)) {
            courses.add(courseName);
            enrollments.put(courseName, new ArrayList<>());
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Course already exists.");
        }
    }

    public static void enrollStudent(String courseName, String studentName) {
    if (courses.contains(courseName)) {

        ArrayList<String> students = enrollments.get(courseName);

        if (!students.contains(studentName)) {
            students.add(studentName);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Student is already enrolled in this course.");
        }

    } else {
        System.out.println("Course not found.");
    }
}
    public static void dropCourse(String courseName) {        if (courses.contains(courseName)) {
            courses.remove(courseName);
            enrollments.remove(courseName);
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public static void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (String course : courses) {
                System.out.println("Course: " + course);
                System.out.println("Students: " + enrollments.get(course));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Course Enrollment System ---");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Drop Course");
            System.out.println("4. View Courses");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    addCourse(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter course name: ");
                    String course = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String student = sc.nextLine();
                    enrollStudent(course, student);
                    break;
                case 3:
                    System.out.print("Enter course name: ");
                    dropCourse(sc.nextLine());
                    break;
                case 4:
                    viewCourses();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
