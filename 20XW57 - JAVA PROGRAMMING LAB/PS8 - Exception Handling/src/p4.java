import java.lang.*;
import java.util.*;

public class p4 {
    public static void main(String[] args) {
        Event e1 = new Event("StageEvent", "d1", "o1", 1);
        Event e2 = new Event("Exhibition", "d2", "o2", 2);
        Event e3 = new Event("SportsMeet", "d3", "o3", 3);

        EventType et1 = new EventType(1, "StageEvent");
        EventType et2 = new EventType(2, "Exhibition");
        EventType et3 = new EventType(3, "SportsMeet");
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
