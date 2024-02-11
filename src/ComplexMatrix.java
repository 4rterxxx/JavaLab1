import java.util.Random;

class ComplexMatrix {
    private ComplexNum[][] matrix;
    private int sizeX, sizeY;
    /**
     * Параметр колличества значений для 1 числа при выводе матрицы
     * */
    // Рекомендуемое значение при обычной работе 8, при перемножении средних матриц >=12
    private int printCapacity = 12;

    ComplexMatrix(int sizeX, int sizeY) {
        matrix = new ComplexNum[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matrix[i][j] = new ComplexNum();
            }
        }
    }

    void setValue(int x, int y, int num) {
        matrix[x][y].setComplexNum(num);
    }

    void setValue(int x, int y, int num, int cnum) {
        matrix[x][y].setComplexNum(num, cnum);
    }

    ComplexNum getValue(int x, int y) {
        return matrix[x][y];
    }
    /**
     * Заполнение матрицы случайными значениями
     * */
    void randomFilling() {
        Random rand = new Random();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                int randint1 = rand.nextInt(20);
                int randint2 = rand.nextInt(20);
                matrix[i][j].setComplexNum(randint1, randint2);
            }
        }
    }
    /**
     * Вывод матрицы
     * */
    void print() {
        String line = "";
        for (int i = 0; i < sizeX; i++) {
            line += "[";
            for (int j = 0; j < sizeY; j++) {
                String cache = matrix[i][j].getStringCNum();
                int k = (printCapacity - cache.length()) / 2;
                for (int c = 0; c < k; c++) line += " ";
                line += cache;
                if (cache.length() % 2 != 0) k++;
                for (int c = 0; c < k; c++) line += " ";
            }
            line += "]\n";
        }
        System.out.println(line);
    }
    /**
     * Возвращает транспонированную матрицу
     * */
    void transparent(){
        ComplexMatrix res = new ComplexMatrix(this.sizeY, this.sizeX);
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                res.setValue(j,i, this.getValue(i,j).getNum(), this.getValue(i,j).getCNum());
            }
        }
        this.matrix = res.matrix;
        this.sizeX = res.sizeX;
        this.sizeY = res.sizeY;
    }
    /**
     * Возвращает резудьтат сложения матриц
     * */
    void add(ComplexMatrix m) {
        if (this.sizeX != m.sizeX || this.sizeY != m.sizeY) {
            throw new IllegalArgumentException("Incorrect sizes of matrices");
        }
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                this.matrix[i][j].add(m.matrix[i][j]);
            }
        }
    }
    /**
     * Возвращает результат умножения матриц
     * */
    void multiplicate(ComplexMatrix m) {
        if (this.sizeX != m.sizeY || this.sizeY != m.sizeX) {
            throw new IllegalArgumentException("Incorrect sizes of matrices");
        }
        ComplexMatrix res = new ComplexMatrix(this.sizeX, m.sizeY);
        for (int i = 0; i < res.sizeX; i++) {
            for (int j = 0; j < res.sizeY; j++) {
                for (int k = 0; k < this.sizeY; k++) {
                    res.matrix[i][j].add(ComplexNum.multiplication(this.matrix[i][k], m.matrix[k][j]));
                }
            }
        }
        this.matrix = res.matrix;
        this.sizeX = res.sizeX;
        this.sizeY = res.sizeY;
    }
}
