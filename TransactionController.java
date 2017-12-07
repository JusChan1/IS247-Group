import java.util.ArrayList;
import java.util.Scanner;

public class TransactionController {
    private static Scanner input = new Scanner(System.in);
    private static final double TransFee = 2.0; // 2) Constant

    public static ArrayList<Account> depositFunds(ArrayList<Account> accounts, int index) { //11) Array List
        System.out.println("Current balance: $" + ((Customer) accounts.get(index)).getBalance());
        System.out.println("Enter the amount of money you would like to deposit:");
        double depFunds = input.nextDouble();
        ((Customer) accounts.get(index)).depositFunds(depFunds);
        return accounts;
    }

    public static ArrayList<Account> withdrawalFunds(ArrayList<Account> accounts, int index) {
        System.out.println("Current balance: $" + ((Customer) accounts.get(index)).getBalance());
        System.out.println("Enter the amount of money you would like to withdrawal from your account:");
        System.out.println("All withdrawals will have a $2.00 service charge.");
        double withdrawFunds = input.nextDouble();
        double afterTransaction = ((Customer) accounts.get(index)).getBalance() - withdrawFunds - TransFee;
        if (afterTransaction < 0)
            System.out.println("This transaction would overdrawn by: " + Math.abs(afterTransaction));
        else {
            System.out.println("Funds are successfully withdrawn. Your remaining balance is: $" + afterTransaction);
            ((Customer) accounts.get(index)).withdrawalFunds(withdrawFunds);
        }
        return accounts;
    }
}
