
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String name;
    boolean isIssued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
    }
}

public class LibrarySystem{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    books.add(new Book(id, name));
                    System.out.println("Book Added Successfully!");
                    break;

                case 2:
                    System.out.println("\n--- BOOK LIST ---");
                    for (Book b : books) {
                        System.out.println("ID: " + b.id + " | Name: " + b.name +
                                " | Status: " + (b.isIssued ? "Issued" : "Available"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();

                    boolean found = false;
                    for (Book b : books) {
                        if (b.id == issueId) {
                            if (!b.isIssued) {
                                b.isIssued = true;
                                System.out.println("Book Issued Successfully!");
                            } else {
                                System.out.println("Book Already Issued!");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();

                    boolean foundReturn = false;
                    for (Book b : books) {
                        if (b.id == returnId) {
                            if (b.isIssued) {
                                b.isIssued = false;
                                System.out.println("Book Returned Successfully!");
                            } else {
                                System.out.println("Book was not issued!");
                            }
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) {
                        System.out.println("Book Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Library System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
