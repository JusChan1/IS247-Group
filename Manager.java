
public class Manager extends Account{ //15) Super
    public Manager(String name, String username, String password){
        super(name, username, password, "Manager");
    }
    public String toString(){
        return super.toString();
    }
}
