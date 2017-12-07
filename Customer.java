
public class Customer extends Account { // 5) Inheritance

    private double accBalance;

    public Customer(String name, String uName, String password, double balance){
        super(name, uName, password, "Customer");
        this.accBalance = balance;
    }
    public double getBalance(){
        return accBalance;
    }
    public void withdrawalFunds(double withdraw){
        accBalance -= withdraw;
    }
    public void depositFunds(double deposit) { accBalance += deposit; }         // Override
    public String toString(){
        return super.toString().concat(" Account Balance: "+accBalance);
    }
}
