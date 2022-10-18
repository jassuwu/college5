import org.jetbrains.annotations.NotNull;

import java.lang.*;
import java.util.*;
public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Hall> halls = new ArrayList<>();
        System.out.println("Enter the number of halls: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            System.out.println("Enter the details for the hall: ");
            String[] input=sc.nextLine().split(",");
            halls.add(new Hall(input[0], input[1], input[2], input[3]));
        }
        System.out.println("BEFORE SORTING OF HALLS: " + halls);
        Collections.sort(halls);
        System.out.println("AFTER SORTING OF HALLS: " + halls);
        System.exit(0);
    }
}

class Hall implements Comparable {
    private String name, contactNumber, ownerName;
    private Double costPerDay;

    public Hall() {
    }

    public Hall(String name, String contactNumber, String costPerDay, String ownerName) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.costPerDay = Double.valueOf(costPerDay);
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

    public void setDetail(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setType(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Hall h = (Hall)o;
        return (int)(this.getCostPerDay()-h.getCostPerDay());
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", costPerDay=" + costPerDay +
                '}';
    }
}