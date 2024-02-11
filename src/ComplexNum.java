class ComplexNum {
    private int num = 0;
    private int cnum = 0;

    ComplexNum() {
        num = 0;
        cnum = 0;
    }

    void setComplexNum(int num) {
        this.num = num;
        cnum = 0;
    }

    void setComplexNum(int num, int cnum) {
        this.num = num;
        this.cnum = cnum;
    }

    int getNum() {
        return num;
    }

    int getCNum() {
        return cnum;
    }
    /**
     * Добавить к числу
     */
    void add(ComplexNum n) {
        this.num += n.num;
        this.cnum += n.cnum;
    }
    /**
     * Операция сложения
     */
    static ComplexNum addition(ComplexNum n1, ComplexNum n2){
        ComplexNum res = new ComplexNum();
        res.num = n1.num + n2.num;
        res.cnum = n1.cnum + n2.cnum;
        return res;
    }
    /**
     * Умножить на число
     */
    void multiplicate(ComplexNum n){
        int a1 = this.getNum(), a2 = n.getNum(), b1 = this.getCNum(), b2 = n.getCNum();
        this.num = a1 * a2 - b1 * b2;
        this.cnum = a1 * b2 + b1 * a2;
    }
    /**
     * Операция умножения
     */
    static ComplexNum multiplication(ComplexNum n1, ComplexNum n2){
        ComplexNum res = new ComplexNum();
        int a1 = n1.getNum(), a2 = n2.getNum(), b1 = n1.getCNum(), b2 = n2.getCNum();
        res.num = a1 * a2 - b1 * b2;
        res.cnum = a1 * b2 + b1 * a2;
        return res;
    }
    /**
     * Возвращает строку с числом
     */
    String getStringCNum() {
        if (cnum == 0) return String.valueOf(num);
        return num + (cnum >= 0 ? "+" : "") + cnum + "i";
    }
}
