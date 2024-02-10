class ComplexNum {
    int num = 0;
    int cnum = 0;

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
    /**
     * Возвращает строку с числом
     * */
    String getCNum() {
        if (cnum == 0) return String.valueOf(num);
        return num + (cnum >= 0 ? "+" : "") + cnum + "i";
    }
}
