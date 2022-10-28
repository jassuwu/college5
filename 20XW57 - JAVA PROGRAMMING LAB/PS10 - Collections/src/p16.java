import java.util.*;

public class p16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customers: ");
        Integer n = Integer.parseInt(sc.nextLine());
        List<TicketBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] booking = sc.nextLine().split(",");
            bookings.add(new TicketBooking(booking[0], Integer.parseInt(booking[1])));
        }

        System.out.println("PRINTING THE MIN TicketBooking: ");
        System.out.println(Collections.min(bookings));
        System.out.println("PRINTING THE MAX TicketBooking: ");
        System.out.println(Collections.max(bookings));

        sc.close();
        System.exit(0);
    }
}

class TicketBooking implements Comparable<TicketBooking> {
    private String customerName;
    private Integer price;

    // Constructors
    public TicketBooking() {
    }

    public TicketBooking(String customerName, Integer price) {
        this.customerName = customerName;
        this.price = price;
    }

    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "TicketBooking{" +
                "customerName='" + customerName + '\'' +
                ", price=" + price +
                '}';
    }

    // compareTo
    @Override
    public int compareTo(TicketBooking o) {
        return this.price.compareTo(o.price);
    }
}