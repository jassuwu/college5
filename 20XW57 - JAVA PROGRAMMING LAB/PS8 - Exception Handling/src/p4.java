import java.lang.*;
import java.util.*;

public class p4 {
    public static void main(String[] args) {
        EventType et1 = new EventType(1, "StageEvent");
        EventType et2 = new EventType(2, "Exhibition");
        EventType et3 = new EventType(3, "SportsMeet");
        ArrayList<EventType> etList = new ArrayList<>();
        etList.add(et1);
        etList.add(et2);
        etList.add(et3);

        Scanner sc = new Scanner(System.in);
        int iterations = Integer.parseInt(sc.nextLine());
        for ( int i = 0; i < iterations; i++) {
            System.out.println("Enter " + (i + 1) + "th Event: ");
            System.out.println("Enter the name: ");
            String name = sc.nextLine();
            System.out.println("Enter the detail: ");
            String detail = sc.nextLine();
            System.out.println("Enter the owner: ");
            String owner = sc.nextLine();
            System.out.println("Enter the typeId: ");
            long typeId = Long.parseLong(sc.nextLine());
        }
    }

    public static boolean isValid(long typeId, ArrayList<EventType> etList) throws EventTypeDoesNotExistsException{
        ArrayList<Long> etIDs = new ArrayList<>();
        for(EventType et : etList) {
            etIDs.add(et.getId());
        }
        if (etIDs.contains(typeId)) {
            return true;
        }
        throw new EventTypeDoesNotExistsException("Event Type does not exist.");
    }
}

class Event {
    private String name;
    private String detail;
    private String ownerName;
    private long typeId;

    public Event(String name, String detail, String ownerName, long typeId) {
        this.name = name;
        this.detail = detail;
        this.ownerName = ownerName;
        this.typeId = typeId;
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

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tname='" + name + '\'' +
                ",\n\tdetail='" + detail + '\'' +
                ",\n\townerName='" + ownerName + '\'' +
                ",\n\ttypeId=" + typeId +
                "\n}";
    }
}

class EventType {
    private long id;
    private String name;

    public EventType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "\n\tid=" + id +
                ",\n\tname='" + name + '\'' +
                "}";
    }
}

class EventTypeDoesNotExistsException extends Exception {
    public EventTypeDoesNotExistsException(String message) {
        super(message);
    }
}