import java.lang.*;
import java.util.*;

public class p5 {
    public static void main(String[] args) {

        int[] arr = { 46, 89, 97, 4, 62, 13, 71, 58, 25, 30 };

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }

        // Printing out the sorted array.
        System.out.println(Arrays.toString(arr));
    }
}
