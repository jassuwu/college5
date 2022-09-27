import java.lang.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers separated by spaces: ");
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        Average av = new Average(arr);
        Minimum mi = new Minimum(arr);
        Maximum ma = new Maximum(arr);

        Thread t1 = new Thread(av);
        Thread t2 = new Thread(mi);
        Thread t3 = new Thread(ma);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("A line at the end of program.");
    }
}



class Average implements Runnable
{
    ArrayList<String> arrL = new ArrayList<>();
    Average(ArrayList<String> al) {
        this.arrL = al;
    }
    public void run(){
        int sum = 0;
        for (String s : arrL) {
            sum += Integer.parseInt(s);
        }
        System.out.println("The Average value is " + sum/arrL.size());
    }
}


class Minimum implements Runnable
{
    ArrayList<String> arrL = new ArrayList<>();
    Minimum(ArrayList<String> al) {
        this.arrL = al;
    }
    public void run(){
        int min = Integer.parseInt(arrL.get(0));
        for (String s : arrL) {
            if (min > Integer.parseInt(s)) {
                min = Integer.parseInt(s);
            }
        }
        System.out.println("The Minimum value is " + min);
    }
}


class Maximum implements Runnable
{
    ArrayList<String> arrL = new ArrayList<>();
    Maximum(ArrayList<String> al) {
        this.arrL = al;
    }
    public void run(){
        int max = Integer.parseInt(arrL.get(0));
        for (String s : arrL) {
            if (max < Integer.parseInt(s)) {
                max = Integer.parseInt(s);
            }
        }
        System.out.println("The Minimum value is " + max);
    }
}