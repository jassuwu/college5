import com.sun.jdi.ArrayReference;
import java.lang.*;
import java.util.*;

public class p6 {
    public static void main(String[] args) {
        ArrayList<HallBooking> hbList = new ArrayList<>();

        Hall h1 = new Hall("h1", "c1", 10.00, "o1");
        Hall h2 = new Hall("h2", "c2", 20.00, "o2");

        Event6 e1 = new Event6("e1", "d1", "ow1", "t1");
        Event6 e2 = new Event6("e2", "d2", "ow2", "t2");
        Event6 e3 = new Event6("e3", "d3", "ow3", "t3");
        Event6 e4 = new Event6("e4", "d4", "ow4", "t4");

        HallBooking hb1 = new HallBooking(h1, e1, new Date(1,1,1), 10.00);
        HallBooking hb2 = new HallBooking(h2, e1, new Date(3,3,3), 30.00);
        HallBooking hb3 = new HallBooking(h2, e4, new Date(4,4,4), 40.00);

        hbList.add(hb1);
        hbList.add(hb2);
        hbList.add(hb3);

        HallBooking hbNew = new HallBooking(h1, e2, new Date(1,1,1), 20.00);

        try {
            if(HallBookingBO.validateHallBooking(hbList, hbNew)) {
                hbList.add(hbNew);
            }
        } catch (HallNotAvailableException e) {
            System.err.println(e);
        }
    }
}

class Hall {
    private String name;
    private String contactNumber;
    private double costPerDay;
    private String ownerName;

    public Hall(String name, String contactNumber, double costPerDay, String ownerName) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.costPerDay = costPerDay;
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", costPerDay=" + costPerDay +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

class Event6 {
    private String name;
    private String detail;
    private String ownerName;
    private String type;

    public Event6(String name, String detail, String ownerName, String type) {
        this.name = name;
        this.detail = detail;
        this.ownerName = ownerName;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event6{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class HallBooking {
    private Hall hall;
    private Event6 event;
    private Date eventDate;
    private double price;

    public HallBooking(Hall hall, Event6 event, Date eventDate, double price) {
        this.hall = hall;
        this.event = event;
        this.eventDate = eventDate;
        this.price = price;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Event6 getEvent() {
        return event;
    }

    public void setEvent(Event6 event) {
        this.event = event;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HallBooking{" +
                "hall=" + hall +
                ", event=" + event +
                ", eventDate=" + eventDate +
                ", price=" + price +
                '}';
    }
}

class HallBookingBO {
    public static boolean validateHallBooking(ArrayList<HallBooking> bookingList, HallBooking booking) throws HallNotAvailableException {
        Set<Hall> hList = new HashSet<>();
        Set<Event6> eList = new HashSet<>();
        for (HallBooking hb : bookingList) {
            hList.add(hb.getHall());
            eList.add(hb.getEvent());
        }

        if (!hList.contains(booking.getHall()) || !eList.contains(booking.getEvent())){
            throw new HallNotAvailableException("Event or Hall doesn't exist.");
        }

        for (HallBooking hb : bookingList) {
            if (booking.getHall() == hb.getHall() && booking.getEventDate() == hb.getEventDate() && booking.getEvent() != hb.getEvent()) {
                throw new HallNotAvailableException();
            }
        }
        return true;
    }
}

class HallNotAvailableException extends Exception {
    public HallNotAvailableException() {
        super("Hall Already Booked");
    }

    public HallNotAvailableException(String message) {
        super(message);
    }
}