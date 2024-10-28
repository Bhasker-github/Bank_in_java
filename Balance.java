package banking;

class Balance {
    int amount = Login.amount;

    public void viewBalance() {
        System.out.println("Your Current Balance is " + amount + " Rupees");
        System.out.println(" ");
    }
}
