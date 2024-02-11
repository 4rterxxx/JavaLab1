public class Main {
    public static void main(String[] args) {
        ComplexMatrix ex = new ComplexMatrix(2, 2);
        ComplexMatrix ex2 = new ComplexMatrix(2, 2);

        ex.randomFilling();
        ex2.randomFilling();

        System.out.println("Начальные случайные матрицы");
        ex.print();
        ex2.print();

        System.out.println("Транспонировали первую:");
        ex.transparent();
        ex.print();

        System.out.println("Прибавили к 1ой вторую:");
        ex.add(ex2);
        ex.print();

        System.out.println("Умножили 1ую на вторую:");
        ex.multiplicate(ex2);
        ex.print();
    }
}



