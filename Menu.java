package banking;

import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in);

    public void menuList() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int opt = s.nextInt();
        switch (opt) {
            case 1:
                System.out.println("========= | REGISTRATION PAGE | =========");
                new Registration().register();
                break;
            case 2:
                System.out.println("========= | LOGIN PAGE | =========");
                new Login().acceptinput();
                break;
            case 3:
                System.exit(200);
                break;
            default:
                System.out.println("========= | WELCOME PAGE | =========");
                menuList();
        }
    }

	
}
