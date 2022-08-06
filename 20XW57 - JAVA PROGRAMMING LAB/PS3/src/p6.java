import java.util.*;

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minutes = Integer.parseInt(sc.nextLine()); // I don't even use this.
        String[] events = sc.nextLine().split(" ");
        sc.close();
        boolean flag = true;
        for (int i = 0; i < events.length - 1; i++) {
            if (events[i].equals(events[i + 1])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
