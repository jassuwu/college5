import java.util.*;

public class p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> ticketCount = new ArrayList<>();
        System.out.println("Enter the number of booked tickets for the 5 days for each show in CSV format: ");
        for (int i = 0; i < 5; i++) {
            String[] input = sc.nextLine().split(",");
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                temp.add(Integer.parseInt(input[j]));
            }
            ticketCount.add(temp);
        }

        System.out.println("Enter the day to know the remaining ticket count: ");
        List<Integer> remainingTickets = ticketCount.get(Integer.parseInt(sc.nextLine()) - 1);
        System.out.println("Thee remaining ticket count for all the shows today: ");
        for (Integer booked : remainingTickets) {
            System.out.print(100 - booked + "");
        }

        sc.close();
        System.exit(0);
    }
}
