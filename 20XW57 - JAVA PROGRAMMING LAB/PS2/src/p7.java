import java.lang.*;
import java.util.*;
public class p7 {
    public static void main(String[] args) {
        int a[][] = {{33, 25, 16, 7},
                {8, 64},
                {53, 96, 81, 78},
                {83, 15}};
        int target = 96;
        System.out.println("Element found at index : " + Arrays.toString(linearSearch(a,target)));

    }
    static int[] linearSearch(int[][] arr, int target)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}

