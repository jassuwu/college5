import java.lang.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seats = new int[100];
        System.out.println("Enter the number of seats to be booked :");
        int total = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < total; i++) {
            try {
                System.out.println("Enter seat no. " + (i + 1) + ": ");
                seats[Integer.parseInt(sc.nextLine())] = 1;
                System.out.println("The seat was booked.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println(e);
            }
        }
    }
}
