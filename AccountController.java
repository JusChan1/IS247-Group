import java.util.ArrayList;
import java.util.Scanner;


public interface AccountController { // 6) Interface
    Scanner input = new Scanner(System.in);

    static int login(ArrayList<Account> accounts) {
        System.out.println("Enter your username");
        String username = input.nextLine();
        Object[] accountsArray = accounts.toArray();
        for (int index = 0;
             index < accountsArray.length; index++) {
                if (accounts.get(index).getUserName().equals(username)) {
                    System.out.println("Enter your account password:");
                    String pasword = input.nextLine();
                    if (accounts.get(index).getPassword().equals(pasword)) {
                        return index;   //returns address of authenticated user in the array list
                    } else {
                        System.out.println("Invalid username password.");
                        return -1;  //returns a negative number to indicate no user has been logged in
                    }
            }
        }
            System.out.println("Username does not exist.");
            return -1;      //returns a negative number to indicate no user has been logged in
             }              //end login method

    static ArrayList<Account> createAccount(ArrayList<Account> accounts){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = s.nextLine();
        System.out.println("Enter your username");
        String username = s.nextLine();

        for(Account a:accounts) {
            if (a.getUserName().equals(username)) {
                System.out.println("Username already exists");
                return accounts;
            }
        }
        System.out.println("Enter your password");
        String password = s.nextLine();
        System.out.println("Enter your starting balance.");
        double balance = s.nextDouble();
        Customer newAcc = new Customer(name, username, password, balance);
        accounts.add(newAcc);
        return accounts;
    }//end create accountMethod



    static ArrayList<Account> deleteAccount(ArrayList<Account> accounts, int index){
        Object[] accountsArray = accounts.toArray();
        if (accountsArray.length < 2){//checks to see if there are no other accounts to delete
            System.out.println("No other accounts exist right now");
            return accounts;
        }
        for (int i =0; i < accountsArray.length; i++) { // 4) Conditional Operator
            if (i != index)
                System.out.println((i + 1) + " " + accounts.get(i).toString());
        }
        System.out.println("Enter the account number for the account you want to close or 0 to leave this menu.");
        Scanner a = new Scanner(System.in);
        int obliterate = a.nextInt();
        obliterate--;
        if (obliterate==index){
            System.out.println("Error: The number you entered is associated with your own account.");
            return accounts;
        }
        else if (obliterate==-1){
            return accounts;
        }
        else {
            System.out.println("Account Deleted: "+accounts.get(obliterate).getUserName());
            accounts.remove(obliterate);
            return accounts;
        }
    }
}