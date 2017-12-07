import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    static private ArrayList<Account> accounts;
    static private boolean logged = false; //tracks logged in status, begins as false to allow user input
    static private int logAccount = -1 ; //tracks currently logged in account index if logged in, start at -1

    public static void main(String[] args) {
        boolean running = true;//keeps menu open
        accounts = new ArrayList<>();    // 7) Abstract Class through "ArrayList<>"
        Manager headManager = new Manager("Manager", "TheMan1", "bestmanager");//creates manager account
        accounts.add(headManager);
        Scanner input = new Scanner(System.in);            //1) Scanner Class
        while (running) {//look keeps menu running until it closing application
            if (!logged) {//
                displayMainMenu();    //display menu
                String userInput = input.nextLine();

                try {
                    // 3) Switch Statement
                    switch (userInput) {
                        case "1":
                            accounts = AccountController.createAccount(accounts);
                            break;
                        case "2":
                            logAccount = AccountController.login(accounts);
                            if (logAccount >= 0)//Method call to check if user logged in
                                logged = true;
                            break;
                        case "3":
                            Scanner scan = new Scanner(System.in);

                            //User inputs the number of transactions
                            System.out.print("How many BTC transactions would you like to calculate: ");
                            int numOfTransaction = scan.nextInt();

                            //Array to store the number of transactions
                            double arrayOfTransactions[] = new double[numOfTransaction];
                            for (int i = 0; i < arrayOfTransactions.length; i++) {
                                System.out.print("BTC -transaction " + (i + 1) + ": ");
                                arrayOfTransactions[i] = scan.nextDouble();
                            }
                            System.out.println("\nTotal = " + calculate(arrayOfTransactions, numOfTransaction) + " BTC\n");
                            break;
                        case "4":
                            running = false;//closes the application
                            break;
                        default:
                            System.out.println("Invalid selection");//happens if user makes invalid input
                            break;                                  // 8) Exception
                    }
                } catch (InputMismatchException a) {
                    System.out.println("Invalid input detected. Please try again.");
                } catch (ArrayIndexOutOfBoundsException b) {
                    System.out.println("You did not enter a valid account number.");
                }
            } else {
                if (accounts.get(logAccount).getType().equals("Manager")) {//checks if manager account is logged in
                    displayMainMenu("Manager", accounts.get(logAccount).getName());//shows manager menu
                    String userChoice = input.nextLine();

                    try {
                        switch (userChoice) {           //8) Excursion
                            case "1":
                                accounts = AccountController.createAccount(accounts);
                                break;
                            case "2":
                                accounts = AccountController.deleteAccount(accounts, logAccount);
                                break;

                            case "3":
                                logged = false;
                                logAccount = -1;
                                break;
                            default:
                                System.out.println("Invalid selection");
                                break;
                        }
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid input detected. Please try again.");
                    } catch (ArrayIndexOutOfBoundsException b) {
                        System.out.println("You did not enter a valid account number.");
                    }

                } else {
                    displayMainMenu(accounts.get(logAccount).getName());//shows customer menu
                    String userChoice = input.nextLine();

                    try {

                        switch (userChoice) {
                            case "1":
                                accounts = TransactionController.withdrawalFunds(accounts, logAccount);
                                break;
                            case "2":
                                accounts = TransactionController.depositFunds(accounts, logAccount);
                                break;
                            case "3":
                                logged = false;
                                logAccount = -1;
                                break;
                            default:
                                System.out.println("Invalid selection");
                                break;
                        }
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid input. Please try again.");
                    } catch (ArrayIndexOutOfBoundsException b) {
                        System.out.println("Invalid account number.");
                    }
                }
            }
        }
    }
    private static void displayMainMenu(){
        System.out.println("Enter the number for the service you want to use");
        System.out.println("1 Create an account");
        System.out.println("2 Login to an account");
        System.out.println("3 Use Bitcoin Calculator");
        System.out.println("4 Quit");
    }//end displayMainMenu for unauthenticated users
    private static void displayMainMenu(String customerName){
        System.out.println("Hello, "+customerName+"!");
        System.out.println("Enter the number for the service you want to use");
        System.out.println("1 Withdraw funds");
        System.out.println("2 Deposit funds");
        System.out.println("3 Logout");
    }//end displayMainMenu for customer accounts
    private static void displayMainMenu(String accType, String managerName){   //10) Method Overloading
        System.out.println(accType+" Menu. Manager: "+managerName);
        System.out.println("Select management option");
        System.out.println("1 Create manager account");
        System.out.println("2 Delete account");
        System.out.println("3 Logout");
    }//end printManinMenu for manager accounts
    private static double calculate(double A[], int N) {  //9)Recursion
        if (N <= 0)
            return 0;
        return (calculate(A, N - 1) + A[N - 1]);
    }

}