import java.util.*;

public class p18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of events: ");
        Integer n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the event details: ");
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] event = sc.nextLine().split(",");
            events.add(new Event(event[0], Integer.parseInt(event[1]), event[2]));
        }

        System.out.println("Enter the owner to get the frequency: ");
        String owner = sc.nextLine();
        System.out.println(Collections.frequency(events, new Event("noonecares", 0, owner)));
        sc.close();
        System.exit(0);
    }
}

class Event {
    private String eventName;
    private Integer maxTickets;
    private String ownerName;

    // Constructors
    public Event() {
    }

    public Event(String eventName, Integer maxTickets, String ownerName) {
        this.eventName = eventName;
        this.maxTickets = maxTickets;
        this.ownerName = ownerName;
    }

    // Getters and Setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(Integer maxTickets) {
        this.maxTickets = maxTickets;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // toString
    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", maxTickets=" + maxTickets +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (this == null)) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Event e = (Event) o;
        return this.ownerName.equals(e.ownerName);
    }
}