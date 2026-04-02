import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        double hra = basicSalary * 0.20;   // 20% HRA
        double da = basicSalary * 0.10;    // 10% DA
        double tax = basicSalary * 0.05;   // 5% tax

        return basicSalary + hra + da - tax;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- PAYROLL MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee Added!");
                    break;

                case 2:
                    System.out.println("\n--- EMPLOYEE LIST ---");
                    for (Employee e : employees) {
                        System.out.println(e.id + " - " + e.name + " - ₹" + e.basicSalary);
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();

                    boolean found = false;
                    for (Employee e : employees) {
                        if (e.id == empId) {
                            double totalSalary = e.calculateSalary();
                            System.out.println("Total Salary of " + e.name + " = ₹" + totalSalary);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee Not Found!");
                    }
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