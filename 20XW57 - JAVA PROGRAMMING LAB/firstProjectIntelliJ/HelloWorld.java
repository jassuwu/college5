import java.lang.*;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int integer = intScan.nextInt();
        System.out.println("Enter a float: ");
        double doub = intScan.nextDouble();
        System.out.println("Enter a String: ");
        String str = strScan.nextLine();
        System.out.printf("%d, %f, %s",integer, doub, str);
        System.out.printf("\n");
    }
}
