import java.lang.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class p6 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bookings:");
        int noOfBookings = Integer.parseInt(sc.nextLine());
        List<TicketBooking> tbList = new ArrayList<TicketBooking>();
        System.out.println("Enter the booking details:");
        while(noOfBookings > 0) {
            String[] details = sc.nextLine().split("-");
            tbList.add(new TicketBooking(details[0], Double.valueOf(details[1]), new SimpleDateFormat("dd/MM/yyyy").parse(details[2]), details[3]));
            noOfBookings--;
        }
        System.out.println("JSON:\n" + new ExportBooking().exportJSON(tbList));
        System.out.println("CSV:\n" + new ExportBooking().exportCSV(tbList));
    }
}

class TicketBooking {
    private String customer;
    private Double price;
    private Date bookingTime;
    private String  stageEventShow;

    public TicketBooking(String customer, Double price, Date bookingTime, String stageEventShow) {
        this.customer = customer;
        this.price = price;
        this.bookingTime = bookingTime;
        this.stageEventShow = stageEventShow;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStageEventShow() {
        return stageEventShow;
    }

    public void setStageEventShow(String stageEventShow) {
        this.stageEventShow = stageEventShow;
    }

    @Override
    public String toString() {
        return "\nTicketBooking{\n" +
                "\tcustomer='" + customer + '\'' +
                ",\n\tprice=" + price +
                ",\n\tbookingTime=" + new SimpleDateFormat("dd/MM/yyyy").format(bookingTime) +
                ",\n\tstageEventShow='" + stageEventShow + '\'' +
                "\n}";
    }
}

interface Export {
    public String exportJSON(List<TicketBooking> bookings);
    public String exportCSV(List<TicketBooking> bookings);
}

class ExportBooking implements Export {
    @Override
    public String exportJSON(List<TicketBooking> bookings) {
        String result = "[\n";
        for (TicketBooking tb : bookings) {
            result+=tb.toString();
        }
        return result + "\n]";
    }

    @Override
    public String exportCSV(List<TicketBooking> bookings) {
        String result ="customer,price,bookingTime,stageEventShow\n";
        for(TicketBooking tb : bookings) {
            result += tb.getCustomer() + "," +  tb.getPrice() + "," + new SimpleDateFormat("dd/MM/yyyy").format(tb.getBookingTime()) + "," + tb.getStageEventShow() + "\n";
        }
        return result;
    }
}