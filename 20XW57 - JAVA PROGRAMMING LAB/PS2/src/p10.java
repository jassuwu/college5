import java.util.*;

public class p10 {
    public static void main(String args[]) throws Exception {
        int TwoD[][] = {
                { 2, 5, 12 },
                { 22, 54, 55 },
                { 1, 6, 8 }
        };
        int[] oneD = new int[TwoD.length + TwoD[0].length];

        // Convert the 2D array to 1D array
        oneD = TwoDtoOneD(TwoD);

        // Sort the 1D array
        Arrays.sort(oneD);

        // Convert the 1D array to Spiral'd 2D array
        int[][] spiral = OneDtoTwoDSpiral(oneD, TwoD.length, TwoD[0].length);

        // Print the Spiral sorted 2D Array
        for (int[] i : spiral) {
            System.out.println(Arrays.toString(i));
        }

    }

    static int[] TwoDtoOneD(int[][] t) {
        int[] o = new int[] {};
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                o = Arrays.copyOf(o, o.length + 1);
                o[o.length - 1] = t[i][j];
            }
        }
        return o;
    }

    static int[][] OneDtoTwoDSpiral(int[] o, int r, int c) {
        int t[][] = new int[r][c];
        int oInd = 0;
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                t[top][i] = o[oInd++];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                t[i][right] = o[oInd++];
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    t[bottom][i] = o[oInd++];
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    t[i][left] = o[oInd++];
                }
                left++;
            }
        }
        return t;
    }
}