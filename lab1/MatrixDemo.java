package lab1;
public class MatrixDemo {
    public static void main(String[] args) {
        long[][] data = {
                { 2, 1, 5 },
                { 5, 3, 4 },
                { 1, 1, 1 }
        };
        Matrix A = new Matrix(data);
        Matrix AT = A.transpose();
        AT.print();

        System.out.print("SumOfMinimalElementsPerColumn: ");
        System.out.print(AT.getSumOfMinimalElementsPerColumn());
    }
}
