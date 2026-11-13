public class SearchATwoDMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int totalrow = matrix.length;
        int totalcol = matrix[0].length;
        int n = totalrow * totalcol;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int rowindex = mid / totalcol;
            int colindex = mid % totalcol;
            if (matrix[rowindex][colindex] == target) {
                return true;
            } else if (matrix[rowindex][colindex] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 16;

        boolean found = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);
    }
}
