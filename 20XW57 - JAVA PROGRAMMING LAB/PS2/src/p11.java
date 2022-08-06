import java.lang.*;
import java.util.*;

public class p11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        char[] S1 = sc.next().toCharArray();
        char[] S2 = sc.next().toCharArray();
        sc.close();
        int dayCount = 0;

        // Diff. finder
        for (int i = 0; i < length; i++) {
            int diff = Math.abs((int) S1[i] - (int) S2[i]);
            if (diff != 0) {
                dayCount += (int) Math.floor((diff) / 13) + (diff) % 13;
            }
        }
        System.out.println(dayCount);
    }
}
