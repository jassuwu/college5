import java.util.*;
import java.lang.*;

public class p12 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        displayTri(sc.nextInt());
    }

    public static int tVal(int n, int k)
    {
        // base case
        if (n == 0 && k == 0)
            return 1;

        // base case
        if (k < -n || k > n)
            return 0;

        // recursive step.
        return tVal(n - 1, k - 1)
                + tVal(n - 1, k)
                + tVal(n - 1, k + 1);
    }

    public static void displayTri(int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = -i; j <= 0; j++)
                System.out.print(tVal(i, j)
                        + " ");
            for (int j = 1; j <= i; j++)
                System.out.print(tVal(i, j)
                        + " ");
            System.out.println();
        }
    }
}

