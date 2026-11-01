import java.util.Scanner;

class spendWise {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int budget;
        int expenseAmount;
        int totalSpent = 0;
        int remainingBudget;
        int expenseCount = 0;

        int essentials = 0;
        int entertainment = 0;
        int learning = 0;

        int categoryChoice;
        int highestAmount = 0;
        int percentage;

        String expenseName;
        String highestExpense = "No expenses recorded";

        char choice = 'Y';

        boolean categoryValid;
        boolean warningShown = false;

        System.out.println("SPENDWISE");
        System.out.println("SMART STUDENT BUDGET ANALYZER");
        System.out.println();

        System.out.print("Enter your monthly budget: ");
        budget = sc.nextInt();

        while (budget <= 0) {
            System.out.println("Please enter a valid budget.");
            System.out.print("Enter your monthly budget: ");
            budget = sc.nextInt();
        }

        sc.nextLine();

        remainingBudget = budget;

        System.out.println("Budget successfully set to Rs. " + budget);

        while (choice == 'Y' || choice == 'y') {

            System.out.println();
            System.out.println("ADD EXPENSE");

            System.out.print("Enter expense name: ");
            expenseName = sc.nextLine();

            System.out.print("Enter expense amount: ");
            expenseAmount = sc.nextInt();

            while (expenseAmount <= 0) {
                System.out.println("Please enter a valid amount.");
                System.out.print("Enter expense amount: ");
                expenseAmount = sc.nextInt();
            }

            System.out.println("Select expense category:");
            System.out.println("1. Essentials");
            System.out.println("2. Entertainment");
            System.out.println("3. Learning");

            System.out.print("Enter category choice: ");
            categoryChoice = sc.nextInt();

            categoryValid = true;
			
			switch (categoryChoice) {

    case 1:
        essentials = essentials + expenseAmount;
        break;

    case 2:
        entertainment = entertainment + expenseAmount;
        break;

    case 3:
        learning = learning + expenseAmount;
        break;

    default:
        System.out.println("Invalid category!");
        categoryValid = false;
        break;
}

            

            if (categoryValid == false) {
                System.out.println("Please enter the expense again.");
                sc.nextLine();
                continue;
            }

            totalSpent = totalSpent + expenseAmount;
            remainingBudget = budget - totalSpent;
            expenseCount++;

            if (expenseAmount > highestAmount) {
                highestAmount = expenseAmount;
                highestExpense = expenseName;
            }

            System.out.println("Expense added successfully!");

            if (totalSpent * 100 > budget * 75 && warningShown == false) {
                System.out.println("WARNING: You have used more than 75%");
                System.out.println("of your monthly budget!");
                warningShown = true;
            }

            System.out.println("Total Spent: Rs. " + totalSpent);
            System.out.println("Remaining Budget: Rs. " + remainingBudget);

            System.out.println();

            System.out.print("Add another expense? (Y/N): ");
            choice = sc.next().charAt(0);

            sc.nextLine();
        }

        percentage = (totalSpent * 100) / budget;

        System.out.println();
        System.out.println("MONTHLY REPORT");

        System.out.println("Monthly Budget       : Rs. " + budget);
        System.out.println("Total Expenses       : " + expenseCount);
        System.out.println("Total Amount Spent   : Rs. " + totalSpent);
        System.out.println("Remaining Budget     : Rs. " + remainingBudget);

        System.out.println();
        System.out.println("CATEGORY-WISE SPENDING");

        System.out.println("Essentials           : Rs. " + essentials);
        System.out.println("Entertainment        : Rs. " + entertainment);
        System.out.println("Learning             : Rs. " + learning);

        System.out.println();
        System.out.println("SPENDING INSIGHTS");

        System.out.println("Highest Expense      : " + highestExpense);
        System.out.println("Highest Amount       : Rs. " + highestAmount);

        System.out.println("Budget Utilized      : " + percentage + "%");

        if (totalSpent <= budget) {
            System.out.println("Status               : WITHIN BUDGET");
        } else {
            System.out.println("Status               : OVER BUDGET");
        }

        System.out.println();
        System.out.println("THANK YOU FOR USING SPENDWISE");

        sc.close();
    }
}