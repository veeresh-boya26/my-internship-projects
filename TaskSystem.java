
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String name;
    boolean isCompleted;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.isCompleted = false;
    }
}

public class TaskSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- TASK MENU ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();

                    tasks.add(new Task(id, name));
                    System.out.println("Task Added!");
                    break;

                case 2:
                    System.out.println("\n--- TASK LIST ---");
                    for (Task t : tasks) {
                        System.out.println(t.id + " - " + t.name + " - " +
                                (t.isCompleted ? "Completed" : "Pending"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Task ID to Complete: ");
                    int compId = sc.nextInt();

                    boolean found = false;
                    for (Task t : tasks) {
                        if (t.id == compId) {
                            t.isCompleted = true;
                            System.out.println("Task Completed!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Task Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to Delete: ");
                    int delId = sc.nextInt();

                    boolean removed = false;
                    for (int i = 0; i < tasks.size(); i++) {
                        if (tasks.get(i).id == delId) {
                            tasks.remove(i);
                            System.out.println("Task Deleted!");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Task Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

