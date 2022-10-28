import java.util.*;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Stall> stalls = new ArrayList<>();
        System.out.println("Enter the number of stalls: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details for the stall: ");
            String[] input = sc.nextLine().split(",");
            stalls.add(new Stall(input[0], input[1], input[2], input[3]));
        }
        System.out.println("BEFORE REMOVAL OF TEST DATA: " + stalls);
        Iterator<Stall> stallIterator = stalls.iterator();
        while (stallIterator.hasNext()) {
            Stall newS = stallIterator.next();
            if (newS.getName().startsWith("test")) {
                stallIterator.remove();
            }
        }
        System.out.println("AFTER REMOVAL OF TEST DATA: " + stalls);
        sc.close();
        System.exit(0);
    }
}

class Stall {
    private String name, detail, type, ownerName;

    public Stall() {
    }

    public Stall(String name, String detail, String type, String ownerName) {
        this.name = name;
        this.detail = detail;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Stall{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", type='" + type + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}