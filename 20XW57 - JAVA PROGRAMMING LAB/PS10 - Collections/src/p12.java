import java.util.*;

public class p12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new HashMap<>();
        System.out.println("Enter the number of addresses: ");
        Integer n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + "th address: ");
            String[] address = sc.nextLine().split(",");
            if (map.containsKey(address[2])) {
                if (map.get(address[2]).containsKey(address[1])) {
                    map.get(address[2]).put(address[1], map.get(address[2]).get(address[1]) + 1);
                } else {
                    map.get(address[2]).put(address[1], 1);
                }
            } else {
                map.put(address[2], new HashMap<>());
                map.get(address[2]).put(address[1], 1);
            }
            System.out.println("The map is: " + map);
        }

        System.out.println("Enter the state name to get the number of addresses for cities in that state: ");
        String state = sc.nextLine();
        System.out.println("The number of addresses for cities in the state " + state + " are: ");
        for (Map.Entry<String, Integer> entry : map.get(state).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
        System.exit(0);
    }
}
