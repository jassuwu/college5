import java.lang.*;
import java.util.*;
public class p6 {
    public static void main(String[] args) {
        int[] arr = {7, 4, 8, 2, 9};
        int[] sunArr = new int[]{0};
        int maxNow = arr[0];
        int sunInd = 0;
        sunArr[0] = arr[0];

        for(int i = 1; i < arr.length; i++){
            if (arr[i] > maxNow) {
                sunArr = Arrays.copyOf(sunArr, sunArr.length+1);
                sunArr[sunInd+=1] = arr[i];
            }
        }
        System.out.println("Count: " + sunArr.length);
        System.out.println("Buildings: ");
        for ( int i = 0; i < sunArr.length; i++){
            System.out.print(sunArr[i]);
        }
        System.out.println();
    }
}
