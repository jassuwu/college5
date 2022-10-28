import java.util.*;

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Double, Integer> theMap = new TreeMap<>();

        System.out.println("Enter the number of events: ");
        Integer n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the details: ");
        for (int i = 0; i < n; i++) {
            String[] deets = sc.nextLine().split(",");
            Double key = Double.valueOf(deets[1]);
            if (theMap.containsKey(key))
                theMap.put(Double.valueOf(deets[1]), theMap.get(Double.valueOf(deets[1])) + Integer.parseInt(deets[2]));
            else
                theMap.put(Double.valueOf(deets[1]), Integer.parseInt(deets[2]));
        }

        // Print the map
        System.out.println(theMap);

        sc.close();
        System.exit(0);

    }
}
