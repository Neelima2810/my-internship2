import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add an expense");
            System.out.println("2. View expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a description for the expense: ");
                    scanner.nextLine();  // Consume the newline character
                    String description = scanner.nextLine();
                    System.out.print("Enter the amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(description, amount));
                    break;
                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        System.out.println("Expense List:");
                        double totalExpense = 0.0;
                        for (Expense expense : expenses) {
                            System.out.println(expense.description + ": $" + expense.amount);
                            totalExpense += expense.amount;
                        }
                        System.out.println("Total expenses: $" + totalExpense);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Expense Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
