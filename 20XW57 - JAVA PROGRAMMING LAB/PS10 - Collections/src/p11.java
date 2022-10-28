import java.util.*;

public class p11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Address>> addressBook = new HashMap<>();
        System.out.println("Enter the number of contacts: ");
        Integer n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of contact " + (i + 1) + " in CSV format: ");
            String[] contactDetails = sc.nextLine().split(",");
            if (addressBook.containsKey(contactDetails[2])) {
                addressBook.get(contactDetails[2]).add(new Address(contactDetails[0], contactDetails[1],
                        contactDetails[2], contactDetails[3], Integer.parseInt(contactDetails[4])));
            } else {
                List<Address> addresses = new ArrayList<>();
                addresses.add(new Address(contactDetails[0], contactDetails[1], contactDetails[2], contactDetails[3],
                        Integer.parseInt(contactDetails[4])));
                addressBook.put(contactDetails[2], addresses);
            }
        }

        System.out.println("Enter the city name to get the addresses for that city: ");
        String city = sc.nextLine();
        System.out.println("The addresses for the city " + city + " are: ");
        for (Address address : addressBook.get(city)) {
            System.out.println(address);
        }

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
