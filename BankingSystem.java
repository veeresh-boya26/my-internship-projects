import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: ₹" + amt);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: ₹" + amt);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    accounts.add(new Account(accNo, name, bal));
                    System.out.println("Account Created!");
                    break;

                case 2:
                    System.out.println("\n--- ACCOUNT LIST ---");
                    for (Account a : accounts) {
                        System.out.println(a.accNo + " - " + a.name + " - ₹" + a.balance);
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();

                    boolean foundDep = false;
                    for (Account a : accounts) {
                        if (a.accNo == depAcc) {
                            System.out.print("Enter Amount: ");
                            double amt = sc.nextDouble();
                            a.deposit(amt);
                            foundDep = true;
                            break;
                        }
                    }
                    if (!foundDep) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int wdAcc = sc.nextInt();

                    boolean foundWd = false;
                    for (Account a : accounts) {
                        if (a.accNo == wdAcc) {
                            System.out.print("Enter Amount: ");
                            double amt = sc.nextDouble();
                            a.withdraw(amt);
                            foundWd = true;
                            break;
                        }
                    }
                    if (!foundWd) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
