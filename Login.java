package banking;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import DBConnection.DBCon;

class Login {
    static int ac, amount;
    String pw;
    DBCon dbc = new DBCon();

    public void acceptinput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        ac = scanner.nextInt();
        System.out.print("Enter Password: ");
        scanner.nextLine(); // Consume newline
        pw = scanner.nextLine();
        try {
            verify();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    public void verify() throws Exception {
        try {
            dbc.connection();
            String qv = "SELECT * FROM log WHERE accno=" + ac + " AND password='" + pw + "'";
            Statement sv = dbc.con.createStatement();
            ResultSet rs = sv.executeQuery(qv);
            if (rs.next()) {
                do {
                    System.out.println("You Logged In to MLRITM Bank Account Successfully !");
                    amount = rs.getInt("balance");
                    System.out.println("Your Account Balance is: " + amount + " Rupees");
                    new UMenu().showMenu();
                } while (rs.next());
            } else {
                InvalidTransaction loginfailed = new InvalidTransaction("Incorrect Login Credentials !");
                System.out.println(loginfailed.getMessage());
                System.out.println("========= | LOGIN PAGE | =========");
                new Menu().menuList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
