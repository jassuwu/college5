import java.util.*;
import java.time.*;

public class p6 {
    public static void main(String[] args) {
        // Dummy TicketBooking data
        List<TicketBooking> ticketBookings = new ArrayList<>();
        ticketBookings.add(new TicketBooking("name1", LocalDateTime.of(2017, 1, 1, 15, 56), "seat1", 3.0));
        ticketBookings.add(new TicketBooking("name2", LocalDateTime.of(2017, 2, 1, 15, 56), "seat2", 1.0));
        ticketBookings.add(new TicketBooking("name3", LocalDateTime.of(2017, 3, 1, 15, 56), "seat3", 4.0));
        ticketBookings.add(new TicketBooking("name4", LocalDateTime.of(2017, 4, 1, 15, 56), "seat4", 2.0));

        System.out.println("\nBEFORE SORTING OF TICKET BOOKINGS: " + ticketBookings);
        Collections.sort(ticketBookings, new PriceAndBookingTimeComparator());
        System.out.println("\nAFTER SORTING OF TICKET BOOKINGS: " + ticketBookings);
    }
}

class TicketBooking {
    private String stageEventShow;
    private LocalDateTime date;
    private String seatNo;
    private Double price;

    // Constructors
    public TicketBooking() {
    }

    public TicketBooking(String stageEventShow, LocalDateTime date, String seatNo, Double price) {
        this.stageEventShow = stageEventShow;
        this.date = date;
        this.seatNo = seatNo;
        this.price = price;
    }

    // Getters and Setters
    public String getStageEventShow() {
        return stageEventShow;
    }

    public void setStageEventShow(String stageEventShow) {
        this.stageEventShow = stageEventShow;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "TicketBooking{" +
                "stageEventShow='" + stageEventShow + '\'' +
                ", date=" + date +
                ", seatNo='" + seatNo + '\'' +
                ", price=" + price +
                '}';
    }

}

class PriceAndBookingTimeComparator implements Comparator<TicketBooking> {
    @Override
    public int compare(TicketBooking o1, TicketBooking o2) {
        Integer ret = o1.getPrice().compareTo(o2.getPrice());
        if (ret == 0) {
            ret = o1.getDate().compareTo(o2.getDate());
        }
        return ret;
    }
}