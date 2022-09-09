import java.lang.*;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of the event :\n1. Exhibition\n2. StageEvent");
        String type = sc.nextLine();
        System.out.println("Enter the details in CSV format:");
        String[] details = sc.nextLine().split(",");

        Event e = null;
        switch (type) {
            case "1":
                e = new Exhibition(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]), Double.valueOf(details[5]));
                break;
            case "2":
                e = new StageEvent(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]), Double.valueOf(details[5]));
                break;
            default:
                System.out.println("Enter a valid type of show.");
                System.exit(1);
        }
        System.out.println("Exhibition Details" +
                "\nEvent Name: " + e.getName() +
                "\nDetail: " + e.getDetails() +
                "\nType:" + e.getType() +
                "\nOrganiser Name: " + e.getOrganizer());
        System.out.println("The projected revenue for the event is " + e.calculateAmount() + ". ");
    }
}

abstract class Event {
    private String name;
    private String details;
    private String type;
    private String organizer;

    public Event(String name, String details, String type, String organizer) {
        this.name = name;
        this.details = details;
        this.type = type;
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    abstract public double calculateAmount();
}

class Exhibition extends Event {
    private int noOfStalls;
    private double rentPerStall;

    public Exhibition(String name, String details, String type, String organizer, int noOfStalls, double rentPerStall) {
        super(name, details, type, organizer);
        this.noOfStalls = noOfStalls;
        this.rentPerStall = rentPerStall;
    }

    public int getNoOfStalls() {
        return noOfStalls;
    }

    public void setNoOfStalls(int noOfStalls) {
        this.noOfStalls = noOfStalls;
    }

    public double getRentPerStall() {
        return rentPerStall;
    }

    public void setRentPerStall(double rentPerStall) {
        this.rentPerStall = rentPerStall;
    }

    @Override
    public double calculateAmount() {
        return this.getNoOfStalls()*this.getRentPerStall();
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "noOfStalls=" + noOfStalls +
                ", rentPerStall=" + rentPerStall +
                '}';
    }
}

class StageEvent extends Event {
    private int noOfShows;
    private double costPerShow;

    public StageEvent(String name, String details, String type, String organizer, int noOfShows, double costPerShow) {
        super(name, details, type, organizer);
        this.noOfShows = noOfShows;
        this.costPerShow = costPerShow;
    }

    public int getNoOfShows() {
        return noOfShows;
    }

    public void setNoOfShows(int noOfShows) {
        this.noOfShows = noOfShows;
    }

    public double getCostPerShow() {
        return costPerShow;
    }

    public void setCostPerShow(double costPerShow) {
        this.costPerShow = costPerShow;
    }

    @Override
    public double calculateAmount() {
        return this.getNoOfShows()*this.getCostPerShow();
    }

    @Override
    public String toString() {
        return "StageEvent{" +
                "noOfShows=" + noOfShows +
                ", costPerShow=" + costPerShow +
                '}';
    }
}