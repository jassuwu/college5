import java.lang.*;
import java.util.Scanner;
public class p4 {
    public static void main(String[] args){

        //array declaration
        String ansArr[] = new String[100];

        Scanner int_sc = new Scanner(System.in);
        Scanner str_sc = new Scanner(System.in);
        int n = int_sc.nextInt();
        //Calculation of button presses
        for(int i = 0; i < n; i++)
        {
            String AB = str_sc.nextLine();
            int A = Integer.parseInt(AB.substring(0, AB.indexOf(" ")));
            int B = Integer.parseInt(AB.substring(AB.lastIndexOf(" ")+1, AB.length()));
            String CD = str_sc.nextLine();
            int C = Integer.parseInt(CD.substring(0, CD.indexOf(" ")));
            int D = Integer.parseInt(CD.substring(CD.lastIndexOf(" ")+1, CD.length()));

            if ( C < A || D < B)
                ansArr[i] = "IMPOSSIBLE.";
            else
                ansArr[i] = "POSSIBLE.";
        }
        //printing out the array
        for(int i=0;i < n;i++) //using n here as an upper limit to not print the 0 values in the empty spots.
            System.out.println(ansArr[i]);

        System.out.print("\n");
    }
}
