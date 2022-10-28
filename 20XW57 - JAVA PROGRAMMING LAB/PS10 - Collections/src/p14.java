import java.util.*;

public class p14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, List<Address>>> map = new HashMap<>();
        System.out.println("Enter the number of addresses: ");
        Integer n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + "th address: ");
            String[] address = sc.nextLine().split(",");
            if (map.containsKey(address[3])) {
                if (map.get(address[3]).containsKey(address[2])) {
                    map.get(address[3]).get(address[2]).add(
                            new Address(address[0], address[1], address[2], address[3], Integer.parseInt(address[4])));
                } else {
                    map.get(address[3]).put(address[2], new ArrayList<>());
                    map.get(address[3]).get(address[2]).add(
                            new Address(address[0], address[1], address[2], address[3], Integer.parseInt(address[4])));

                }
            } else {
                map.put(address[3], new HashMap<>());
                map.get(address[3]).put(address[2], new ArrayList<>());
                map.get(address[3]).get(address[2])
                        .add(new Address(address[0], address[1], address[2], address[3], Integer.parseInt(address[4])));
            }
            System.out.println("The map is: " + map);
        }
        System.out.println("Enter the state name: ");
        String state = sc.nextLine();
        System.out.println("Enter the city name to get the addresses for that city: ");
        String city = sc.nextLine();
        System.out.println("The addresses for the city " + city + " in " + state + " are: ");
        System.out.println(map.get(state).get(city));
        sc.close();
        System.exit(0);
    }
}

class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Integer pincode;

    // Constructors
    public Address() {
    }

    public Address(String addressLine1, String addressLine2, String city, String state, Integer pincode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    // Getters and Setters
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    // toString
    @Override
    public String toString() {
        return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
                + ", pincode="
                + pincode + ", state=" + state + "]";
    }

}
