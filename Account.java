
public class Account {  // 18) Encapsulation
    private String uName; // Wrapping variables together as a single unit
    private String pw;
    private String type;
    private String name;



    public Account(String name, String userName, String password, String type){
        this.uName = userName;
        this.pw = password;
        this.type = type;
        this.name = name;
    }
    public String getUserName(){
        return uName;
    }
    public String getPassword(){
        return pw;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        String rString =""; // return string
        rString = rString.concat("Name: "+name+" User Name: "+uName+" Type: "+type);
        return rString;
    }
}
