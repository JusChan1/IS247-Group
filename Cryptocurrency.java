public class Cryptocurrency {

    private final String name;
    private final int conversion;
    private final String type;


    public Cryptocurrency (String name, int conversion, String type) {
        this.name = name;
        this.conversion = conversion;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return conversion;
    }

    public String getType() { return type; }

    @Override
    public String toString() {
        return "coin {" + "name: '" + name + "\'" + ", value: " + conversion + ", type: " + type + '}';
    }
}
