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

        printWallet(wallet);

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
        /*
        for (Cryptocurrency coin : coins) {
            System.out.println("coin: " + coin.getName() + " || value(USD): " + coin.getValue() + " || type: " + coin.getType());
        }
        System.out.println("-----------------------------------");
        */
        printCoinList(coins);

        //Using Stack
        Stack coinStack = new Stack();

        for (Cryptocurrency coin : coins ) {
            coinStack.push(coin);
        }
        printCoins(coinStack);
    }

    public static void printWallet(Map<String, String> wallet) {
        System.out.println("Wallet: " + wallet);
        System.out.println("Wallet Size:  " + wallet.size());
        System.out.println("---------------------------------");
        System.out.println("Coins:");
    }

    public static void printCoins(Stack coinStack) {
        System.out.println(coinStack);
        System.out.println("All virtual coins displayed.");
    }

    public static void printCoinList(Collection<Cryptocurrency> coins) {
        for (Cryptocurrency coin : coins) {
            System.out.println("coin: " + coin.getName() + " || value(USD): " + coin.getValue() + " || type: " + coin.getType());
        }
        System.out.println("-----------------------------------");
    }
}