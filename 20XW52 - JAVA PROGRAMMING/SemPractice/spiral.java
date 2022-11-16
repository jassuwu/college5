public class spiral {
    public static void main(String[] args) {
        int arr[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.println("Matrix form: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Spiral Order: ");
        printSpiral(arr);
    }

    static void printSpiral(int[][] arr) {
        int top = 0;
        int right = arr[0].length - 1;
        int bottom = arr.length - 1;
        int left = 0;
        int dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(arr[top][i] + " ");
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(arr[i][right] + " ");
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
    }
}
