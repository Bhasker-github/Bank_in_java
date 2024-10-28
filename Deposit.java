package banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import DBConnection.DBCon;

class Deposit {
    int amount = Login.amount;
    int ac = Login.ac;
    DBCon dbc = new DBCon();

    public int userinput() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the amount to be deposited: ");
			int amt = scanner.nextInt();
			if (amt <= 0) {
			    InvalidTransaction depositNegativeError = new InvalidTransaction("Invalid Deposit Amount");
			    System.out.println(depositNegativeError.getMessage());
			    amt = userinput(); // Recursive call if invalid input
			}
			return amt;
		}
    }

    public void deposit_amount(int amt) {
        amount += amt;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = dbc.connection();
            String qv = "UPDATE log SET deposit = ?, balance = ? WHERE accno = ?";
            pstmt = con.prepareStatement(qv);
            pstmt.setInt(1, amt);
            pstmt.setInt(2, amount);
            pstmt.setInt(3, ac);
            int rs = pstmt.executeUpdate();
            
            if (rs > 0) {
                System.out.println("Amount deposited Successfully");
                System.out.println("");
                System.out.println("Total Balance: " + amount);
                System.out.println(" ");
            }
            
            Login.amount = amount;
            new UMenu().showMenu();
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
