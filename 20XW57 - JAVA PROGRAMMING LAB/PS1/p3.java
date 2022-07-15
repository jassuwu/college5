import java.lang.*;
import java.util.Scanner;
public class p3 {
    public static void main(String[] args){

        //array declaration
        int ansArr[] = new int[100];

        Scanner int_sc = new Scanner(System.in);
        Scanner str_sc = new Scanner(System.in);
        int n = int_sc.nextInt();
        //Calculation of button presses
        for(int i = 0; i < n; i++)
        {
            String str = str_sc.nextLine();
            int num1 = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            int num2 = Integer.parseInt(str.substring(str.lastIndexOf(" ")+1, str.length()));
            ansArr[i] = Math.abs(num1 - num2);
        }
        //printing out the array
        for(int i=0;i < n;i++) //using n here as an upper limit to not print the 0 values in the empty spots.
            System.out.println(ansArr[i]);

        System.out.print("\n");
    }
}
