import java.util.*;
import java.lang.*;
public class p2 {
    public static void main(String[] args){
        int[] a = {10, 20, 30, 40, 50};
        rotate(a,2, a.length);
    }
    public static void rotate(int ar[], int d, int n)
    {
        int rounds = 1;
        while (rounds <= d) {
            int last = ar[0];
            for (int i = 0; i < n - 1; i++) {
                ar[i] = ar[i + 1];
            }
            ar[n - 1] = last;
            rounds++;
        }

        for (int i : ar) {
            System.out.print(i + " ");
        }
    }
}
