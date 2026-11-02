port java.util.Scanner;

class Main {
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

        int savingsGoal;

        String expenseName;
        String highestExpense = "";

        char choice = 'Y';
        boolean categoryValid;

        System.out.println("");
        System.out.println("             SPENDWISE");
        System.out.println("     SMART STUDENT BUDGET ANALYZER");
        System.out.println("");

        System.out.print("Enter your monthly budget: ");
        budget = sc.nextInt();

        while (budget <= 0) {
            System.out.println("Enter a valid budget.");
            budget = sc.nextInt();
        }

        System.out.print("Enter your savings goal: ");
        savingsGoal = sc.nextInt();

        sc.nextLine();

        System.out.println("Budget successfully set to Rs. " + budget);

        remainingBudget = budget;

        while (choice == 'Y' || choice == 'y') {

            System.out.println("");
            System.out.println("             ADD EXPENSE");
            System.out.println("");

            System.out.print("Enter expense name: ");
            expenseName = sc.nextLine();

            System.out.print("Enter expense amount: ");
            expenseAmount = sc.nextInt();

            if (expenseAmount <= 0) {
                System.out.println("Invalid expense amount!");
                sc.nextLine();
                continue;
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
            }

            if (categoryValid == false) {
                System.out.println("Please enter expense again.");
                sc.nextLine();
                continue;
            }

            System.out.println("Expense added successfully!");

            totalSpent = totalSpent + expenseAmount;
            remainingBudget = budget - totalSpent;
            expenseCount++;

            if (expenseAmount > highestAmount) {
                highestAmount = expenseAmount;
                highestExpense = expenseName;
            }

            if (totalSpent * 100 > budget * 75) {
                System.out.println("WARNING: You have used more than 75%");
                System.out.println("of your monthly budget!");
            }

            System.out.println("Total Spent: Rs. " + totalSpent);
            System.out.println("Remaining Budget: Rs. " + remainingBudget);

            System.out.println("");

            System.out.print("Add another expense? (Y/N): ");
            choice = sc.next().charAt(0);

            sc.nextLine();
        }

        percentage = (totalSpent * 100) / budget;

        System.out.println("");
        System.out.println("           MONTHLY REPORT");
        System.out.println("");

        System.out.println("Monthly Budget       : Rs. " + budget);
        System.out.println("Total Expenses       : " + expenseCount);
        System.out.println("Total Amount Spent   : Rs. " + totalSpent);
        System.out.println("Remaining Budget     : Rs. " + remainingBudget);

        System.out.println("");
        System.out.println("         CATEGORY-WISE SPENDING");
        System.out.println("");

        System.out.println("Essentials           : Rs. " + essentials);
        System.out.println("Entertainment        : Rs. " + entertainment);
        System.out.println("Learning             : Rs. " + learning);

        System.out.println("");
        System.out.println("          SPENDING INSIGHTS");
        System.out.println("");

        System.out.println("Highest Expense      : " + highestExpense);
        System.out.println("Highest Amount       : Rs. " + highestAmount);

        System.out.println("Budget Utilized      : " + percentage + "%");

        if (totalSpent < budget) {
            System.out.println("Status               : WITHIN BUDGET");
        }
		 else if (totalSpent==budget) {
			 System.out.println("Status                :Budget Fully Used");
		 }
		else {
            System.out.println("Status               : OVER BUDGET");
        }

        System.out.println("");
        System.out.println("          SAVINGS GOAL TRACKER");
        System.out.println("");

        System.out.println("Your Savings Goal: Rs. " + savingsGoal);
        System.out.println("Available Money: Rs. " + remainingBudget);

        if (remainingBudget >= savingsGoal) {
            System.out.println("Congratulations! Savings goal achieved.");
        } else {
            System.out.println("You need to save more money.");
            System.out.println("Shortfall: Rs. " + (savingsGoal - remainingBudget));
        }

        System.out.println("");
        System.out.println("       THANK YOU FOR USING SPENDWISE");
        System.out.println("");

        sc.close();
    }
}
