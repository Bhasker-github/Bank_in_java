package banking;

import java.sql.Statement;
import java.util.Scanner;
import DBConnection.DBCon;

public class Registration {
    Scanner s = new Scanner(System.in);
    DBCon db = new DBCon();

    public void register() {
        System.out.println("Account Number: ");
        String accno = s.nextLine();
        System.out.println("Name: ");
        String name = s.nextLine();
        System.out.println("Email ID: ");
        String email = s.nextLine();
        System.out.println("Contact No: ");
        String contact = s.nextLine();
        System.out.println("Username: ");
        String username = s.nextLine();
        System.out.println("Enter your Password: ");
        String password = s.nextLine();

        // Get the deposit amount
        int deposit = 0;
        boolean validDeposit = false;
        
        while (!validDeposit) {
            System.out.println("Enter your Initial Deposit Amount (Minimum Rs. 5000): ");
            try {
                deposit = s.nextInt();
                if (deposit >= 5000) {
                    validDeposit = true;
                } else {
                    System.out.println("Deposit must be at least Rs. 5000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        int withdraw = 0;
        int balance = deposit - withdraw;

        int opt = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.println("Enter your choice:\n1. Submit\n2. Reset\n3. Exit");
            try {
                opt = s.nextInt();
                if (opt >= 1 && opt <= 3) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (1, 2, or 3).");
            }
        }

        db.connection();
        try {
            if (opt == 1) {
                String qry = "INSERT INTO log(accno, name, email, contact, uname, password, deposit, withdraw, balance) VALUES ('" + accno + "','" + name + "','" + email + "','" + contact + "','" + username + "','" + password + "','" + deposit + "','" + withdraw + "','" + balance + "')";
                Statement st = db.con.createStatement();
                int rs = st.executeUpdate(qry);
                if (rs > 0) {
                    System.out.println("========= | WELCOME PAGE | =========");
                    Main.main(null);
                } else {
                    System.out.println("Error during the registration process.");
                    System.out.println("========= | REGISTRATION PAGE | =========");
                    register();
                }
            } else if (opt == 2) {
                System.out.println("========= | REGISTRATION PAGE | =========");
                register();
            } else if (opt == 3) {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
