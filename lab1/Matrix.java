package lab4;
/**
 * Клас Matrix представляє двовимірну матрицю з елементами типу long.
 * Підтримує операції транспонування та обчислення суми мінімальних елементів стовпців.
 */
public class Matrix {
    /** Кількість рядків матриці (immutable). */
    private final int rows;

    /** Кількість стовпців матриці (immutable). */
    private final int cols;

    /** Внутрішнє представлення матриці у вигляді 2D масиву long. */
    private final long[][] a;

    /**
     * Конструктор створює матрицю на основі переданого двовимірного масиву.
     * Виконує перевірку на пустий масив та однакову довжину рядків.
     *
     * @param data двовимірний масив long, з якого створюється матриця
     * @throws IllegalArgumentException якщо data == null, data порожній або рядки різної довжини
     */
    public Matrix(long[][] data) {
        // Validate input data
        if (data == null || data.length == 0) throw new IllegalArgumentException("Matrix can not be empty");
        
        // Copy data to internal array
        this.rows = data.length;
        this.cols = data[0].length;
        this.a = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) throw new IllegalArgumentException("All rows must be the same lenght");
            System.arraycopy(data[i], 0, this.a[i], 0, cols);
        }
    }

    /**
     * Повертає транспоновану матрицю (рядки стають стовпцями і навпаки).
     *
     * @return новий об'єкт Matrix — транспонована матриця
     */
    public Matrix transpose() {
        Matrix T = new Matrix(this.a);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                T.a[i][j] = this.a[j][i];
            }
        }
        return T;
    }

    /**
     * Обчислює суму мінімальних елементів кожного стовпця.
     *
     * @return сума мінімальних елементів стовпців
     */
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
    
    /**
     * Виводить матрицю у консоль у вигляді рядків та стовпців.
     */
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
