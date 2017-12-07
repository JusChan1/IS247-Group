import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class Cryptocurrencies {

    public static void main(String[] args) {

        Cryptocurrency bitcoin = new Cryptocurrency("Bitcoin", 9956, "major cryptocurrency");
        Cryptocurrency litecoin = new Cryptocurrency("Litecoin", 94, "major cryptocurrency");
        Cryptocurrency ether = new Cryptocurrency("Ether", 947, "major cryptocurrency");
        Cryptocurrency neo = new Cryptocurrency("NEO", 36, "altcoin");
        Cryptocurrency lnk = new Cryptocurrency("LinkPlatform(LNK)", 21, "altcoin");
        Cryptocurrency bitcash = new Cryptocurrency("Bitcoin Cash", 1188, "derivative");
        Cryptocurrency bitgold = new Cryptocurrency("Bitcoin Gold", 130, "derivative");
        Cryptocurrency steem = new Cryptocurrency("Steem", 1, "social coin");

        //Using Map and HashMap
        Map<String, String> wallet = new HashMap<>();
        wallet.put("Bitcoin", "major cryptocurrency");
        wallet.put("Ether", "major cryptocurrency");
        wallet.put("Litecoin", "major cryptocurrency");
        wallet.put("NEO", "altcoin");
        wallet.put("LNK", "altcoin");
        wallet.put("Bitcoin Cash", "derivative");
        wallet.put("Bitcoin Gold", "derivative");
        wallet.put("Steem", "social coin");

        //Using List
        Collection<Cryptocurrency> coins = new ArrayList<>();
        coins.add(bitcoin);
        coins.add(litecoin);
        coins.add(neo);
        coins.add(lnk);
        coins.add(ether);
        coins.add(bitcash);
        coins.add(bitgold);
        coins.add(steem);

        //Using Stack
        Stack coinStack = new Stack();

        for (Cryptocurrency coin : coins) {
            coinStack.push(coin);
        }

        Scanner input = new Scanner(System.in);            //1) Scanner Class
        boolean running = true;//keeps menu open
        while (running) {//look keeps menu running until it closing application
            displayCoinMenu();    //display menu
            String userInput = input.nextLine();

            try {
                // 3) Switch Statement
                switch (userInput) {
                    case "1":
                        printWallet(wallet);
                        break;
                    case "2":
                        printCoins(coinStack);
                        break;
                    case "3":
                        printCoinList(coins);
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
        }
    }
    private static void displayCoinMenu() {
        System.out.println("Enter the number for the service you want to use");
        System.out.println("1 View Wallet");
        System.out.println("2 View All Coins");
        System.out.println("3 View List of Coins");
        System.out.println("4 Quit");
    }

    private static void printWallet(Map<String, String> wallet) {
        System.out.println("Wallet: " + wallet);
        System.out.println("Wallet Size:  " + wallet.size());
        System.out.println("---------------------------------");
        System.out.println("Coins:");
    }

    private static void printCoins(Stack coinStack) {
        System.out.println(coinStack);
        System.out.println("All virtual coins displayed.");
    }

    private static void printCoinList(Collection<Cryptocurrency> coins) {
        for (Cryptocurrency coin : coins) {
            System.out.println("coin: " + coin.getName() + " || value(USD): " + coin.getValue() + " || type: " + coin.getType());
        }
        System.out.println("-----------------------------------");
    }
}
