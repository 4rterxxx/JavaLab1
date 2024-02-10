public class Main {
    public static void main(String[] args) {
        ComplexMatrix ex = new ComplexMatrix(3, 3);
        ComplexMatrix ex2 = new ComplexMatrix(3, 3);

        ex.randomFilling();
        ex2.randomFilling();

        System.out.println("Начальные случайные матрицы");
        ex.print();
        ex2.print();

        System.out.println("Транспонировали первую:");
        ex = ComplexMatrix.transparent(ex);
        ex.print();

        System.out.println("Сложили матрицы:");
        ex = ComplexMatrix.addition(ex,ex2);
        ex.print();

        System.out.println("Умножили матрицы:");
        ex = ComplexMatrix.multiplication(ex, ex2);
        ex.print();
    }
}



