import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
public class p4 {
    public static void main(String[] args) {
        int[] a = {3, 15, 26, 37, 49, 55, 63, 76, 81, 93};
        int compareCount = 0;
        int searchElement = 76;

        //Binary Search
        Arrays.sort(a);

        int low = 0;
        int high = a.length-1;
        int mid = (low+high)/2;
        while(true) {
            if(a[mid] < searchElement ){
                low = mid;
                mid = (low+high)/2;
            }
            else if(a[mid] > searchElement) {
                high = mid;
                mid = (low+high)/2;
            }
            else {
                System.out.println("Index : " + mid + "\nElement : " +  a[mid]);
                break;
            }
        }
    }
}
