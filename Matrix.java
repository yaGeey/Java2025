

public class Matrix {
    // final = immutable
    private final int rows;
    private final int cols;
    private final long[][] a; // 2d matrix array with long elements

    // Constructor
    public Matrix(long[][] data) {
        // Validate input data
        if (data == null || data.length == 0) throw new IllegalArgumentException("Matrix can not be empty");
        
        // Copy data to internal array
        this.rows = data.length;
        this.cols = data[0].length;
        this.a = new long[rows][cols]; // new empty matrix

        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) throw new IllegalArgumentException("All rows must be the same lenght");
            System.arraycopy(data[i], 0, this.a[i], 0, cols); // Copy each row
        }
    }

    // transpose - rows -> cols, cols -> rows
    public Matrix transpose() {
        Matrix T = new Matrix(this.a);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                T.a[i][j] = this.a[j][i];
            }
        }
        return T;
    }

    public long getSumOfMinimalElementsPerColumn() {
        long sum = 0;
        for (int j = 0; j < cols; j++) {
            long min = a[0][j]; // start with first element in column
            for (int i = 0; i < rows; i++) {
                min = Math.min(min, a[i][j]);
            }
            sum += min;
        }
        return sum;
    }
    
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
