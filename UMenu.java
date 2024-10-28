package banking;

import java.util.Scanner;

class UMenu {
    int selectedOption;
    BankingAccount b = new BankingAccount();

    public void showMenu() {
        System.out.println("Please Select an option below:");
        System.out.println("Press 1 to Deposit Amount.");
        System.out.println("Press 2 to Withdraw Amount.");
        System.out.println("Press 3 to View Balance");
        System.out.println("Press any key to Logout");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press any key: ");
        selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                int deposit = new Deposit().userinput();
                new Deposit().deposit_amount(deposit);
                showMenu();
                break;
            case 2:
                System.out.print("Please Enter the amount to withdraw: ");
                int withamt = new Withdrawal().userInput();
                new Withdrawal().withdraw_amount(withamt);
                showMenu();
                break;
            case 3:
                new Balance().viewBalance();
                showMenu();
                break;
            default:
                System.out.println("Transaction Ended, Your MLRITM Bank Account Logout Successfully !");
                System.exit(0);
                break;
        }
        scanner.close();
    }
}
