import java.util.Random;

class ComplexMatrix {
    private ComplexNum[][] matrix;
    private int sizeX, sizeY;
    /**
     * Параметр колличества значений для 1 числа при выводе матрицы
     * */
    // Рекомендуемое значение при обычной работе 8, при перемножении средних >=12
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
                String cache = matrix[i][j].getCNum();
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
    static ComplexMatrix transparent(ComplexMatrix m){
        ComplexMatrix res = new ComplexMatrix(m.sizeY, m.sizeX);
        for (int i = 0; i < m.sizeX; i++) {
            for (int j = 0; j < m.sizeY; j++) {
                res.setValue(j,i, m.getValue(i,j).num, m.getValue(i,j).cnum);
            }
        }
        return res;
    }
    /**
     * Возвращает резудьтат сложения матриц
     * */
    static ComplexMatrix addition(ComplexMatrix m1, ComplexMatrix m2) {
        if (m1.sizeX != m2.sizeX || m1.sizeY != m2.sizeY) {
            throw new IllegalArgumentException("Incorrect sizes of matrices");
        }
        ComplexMatrix res = new ComplexMatrix(m1.sizeX, m1.sizeY);
        for (int i = 0; i < res.sizeX; i++) {
            for (int j = 0; j < res.sizeY; j++) {
                res.setValue(i, j, m1.getValue(i, j).num + m2.getValue(i, j).num, m1.getValue(i, j).cnum + m2.getValue(i, j).cnum);
            }
        }
        return res;
    }
    /**
     * Возвращает результат умножения матриц
     * */
    static ComplexMatrix multiplication(ComplexMatrix m1, ComplexMatrix m2) {
        if (m1.sizeX != m2.sizeY || m1.sizeY != m2.sizeX) {
            throw new IllegalArgumentException("Incorrect sizes of matrices");
        }
        ComplexMatrix res = new ComplexMatrix(m1.sizeX, m1.sizeY);
        for (int i = 0; i < res.sizeX; i++) {
            for (int j = 0; j < res.sizeY; j++) {
                int cache = 0, ccache = 0;
                for (int k = 0; k < m1.sizeY; k++) {
                    int a1 = m1.getValue(i, k).num, a2 = m2.getValue(k, j).num, b1 = m1.getValue(i, k).cnum, b2 = m2.getValue(k, j).cnum;
                    cache += a1 * a2 - b1 * b2;
                    ccache += a1 * b2 + b1 * a2;
                }
                res.setValue(i, j, cache, ccache);
            }
        }
        return res;
    }
}
