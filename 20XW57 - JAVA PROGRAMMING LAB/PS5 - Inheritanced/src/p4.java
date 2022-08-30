import java.lang.*;
import java.util.*;

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the event :");
        String name = sc.nextLine();
        System.out.println("Enter the detail of the event :");
        String detail = sc.nextLine();
        System.out.println("Enter the owner of the event :");
        String owner = sc.nextLine();
        System.out.println("Enter the type of the event :\n1. Exhibition\n2. StageEvent");
        String type = sc.nextLine();

        Event e = new Event(name, detail, owner);
        switch (type) {
            case "1":
                System.out.println("Enter the no. of stalls :");
                String noOfStalls = sc.nextLine();
                e = new Exhibition(name, detail, owner, Integer.parseInt(noOfStalls));
                break;
            case "2":
                System.out.println("Enter the no. of shows :");
                String noOfShows = sc.nextLine();
                System.out.println("Enter the no. of seats per show :");
                String noOfSeatsPerShow = sc.nextLine();
                e = new StageEvent(name, detail, owner, Integer.parseInt(noOfShows), Integer.parseInt(noOfSeatsPerShow));
                break;
            default:
                System.out.println("Enter a valid type of show.");
                System.exit(1);
        }
        System.out.println("The projected revenue for the event is " + e.projectedRevenue() + ". ");
    }
}

class Event {
    protected String name;
    protected String detail;
    protected String ownerName;

    public Event(String name, String detail, String ownerName) {
        this.name = name;
        this.detail = detail;
        this.ownerName = ownerName;
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

    public double projectedRevenue() {
        return 0.00;
    }
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

class Exhibition extends Event {
    protected int noOfStalls;

    public Exhibition(String name, String detail, String ownerName, int noOfStalls) {
        super(name, detail, ownerName);
        this.noOfStalls = noOfStalls;
    }

    public int getNoOfStalls() {
        return noOfStalls;
    }

    public void setNoOfStalls(int noOfStalls) {
        this.noOfStalls = noOfStalls;
    }

    @Override
    public double projectedRevenue() {
        return 10000 * this.getNoOfStalls();
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "noOfStalls=" + noOfStalls +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

class StageEvent extends Event {
    protected int noOfShows;
    protected int noOfSeatsPerShow;

    public StageEvent(String name, String detail, String ownerName, int noOfShows, int noOfSeatsPerShow) {
        super(name, detail, ownerName);
        this.noOfShows = noOfShows;
        this.noOfSeatsPerShow = noOfSeatsPerShow;
    }

    public int getNoOfShows() {
        return noOfShows;
    }

    public void setNoOfShows(int noOfShows) {
        this.noOfShows = noOfShows;
    }

    public int getNoOfSeatsPerShow() {
        return noOfSeatsPerShow;
    }

    public void setNoOfSeatsPerShow(int noOfSeatsPerShow) {
        this.noOfSeatsPerShow = noOfSeatsPerShow;
    }

    @Override
    public double projectedRevenue() {
        return 50 * this.getNoOfSeatsPerShow()* this.getNoOfShows();
    }


    @Override
    public String toString() {
        return "StageEvent{" +
                "noOfShows=" + noOfShows +
                ", noOfSeatsPerRow=" + noOfSeatsPerShow +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}


