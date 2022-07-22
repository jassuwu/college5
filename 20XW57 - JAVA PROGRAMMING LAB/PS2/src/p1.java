import java.util.*;
import java.lang.*;
public class p1 {
    public static void main(String[] args){
        int[] a = {23, 45, 86, 77, 9, 54, 13, 36, 61, 98};
        int searchElement = 54;
        for ( int i = 0; i < a.length; i++) {
            if ( a[i] == searchElement) {
                System.out.println("Element found at index " + i + ".");
            }
        }
    }
}
