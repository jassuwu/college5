import java.lang.*;
import java.util
        .*;
public class p5 {
    public static void main(String[] args) {
        int[] arr = {46, 89, 97, 4, 62, 13, 71, 58, 25, 30};

        for(int i = 0; i < arr.length - 1; i++){
            int min = 999999999;
            int minInd = 999;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < min)
                    min = arr[j];
                    minInd = j;
            }
            if(minInd != 999){
                int temp = arr[minInd];
                arr[minInd] = arr[i];
                arr[i] = temp;
            }
        }

        for( int i : arr ){
            System.out.println(i);
        }
    }
}
