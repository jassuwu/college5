import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class p13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<LocalDate, Map<String, Integer>> map = new HashMap<>();
        System.out.println("Enter the number of show times: ");
        Integer n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + "th show time: ");
            String[] showTime = sc.nextLine().split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            LocalDate date = LocalDate.parse(showTime[0], formatter);
            if (map.containsKey(date)) {
                if (map.get(date).containsKey(showTime[1])) {
                    map.get(date).put(showTime[1], map.get(date).get(showTime[1]) + Integer.parseInt(showTime[2]));
                } else {
                    map.get(date).put(showTime[1], Integer.parseInt(showTime[2]));
                }
            } else {
                map.put(date, new HashMap<>());
                map.get(date).put(showTime[1], Integer.parseInt(showTime[2]));
            }
            System.out.println("The map is: " + map);
        }

        System.out.println("Enter the date and show time to get the number tickets booked: ");
        String[] showTime = sc.nextLine().split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate date = LocalDate.parse(showTime[0], formatter);
        System.out.println("The number of tickets booked for the show time " + showTime[1] + " on " + date + " are: "
                + map.get(date).get(showTime[1]));

        sc.close();
        System.exit(0);
    }
}
