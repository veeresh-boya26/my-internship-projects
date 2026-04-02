import java.util.ArrayList;
import java.util.Scanner;

class Course {
    int id;
    String name;

    Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student {
    String name;
    ArrayList<Course> enrolledCourses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course c) {
        enrolledCourses.add(c);
        System.out.println("Enrolled in: " + c.name);
    }

    void viewCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled!");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course c : enrolledCourses) {
                System.out.println(c.id + " - " + c.name);
            }
        }
    }
}

public class  CourseSystem{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Available courses
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "Java"));
        courseList.add(new Course(2, "Python"));
        courseList.add(new Course(3, "Web Development"));

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        Student student = new Student(studentName);

        int choice;

        do {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1. View Available Courses");
            System.out.println("2. Enroll Course");
            System.out.println("3. View My Courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Courses:");
                    for (Course c : courseList) {
                        System.out.println(c.id + " - " + c.name);
                    }
                    break;

                case 2:
                    System.out.print("Enter Course ID to Enroll: ");
                    int cid = sc.nextInt();

                    boolean found = false;
                    for (Course c : courseList) {
                        if (c.id == cid) {
                            student.enrollCourse(c);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Course Not Found!");
                    }
                    break;

                case 3:
                    student.viewCourses();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
