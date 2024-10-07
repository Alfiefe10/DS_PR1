package edu.uoc.ds.samples.module2;

public class Matrix {

    private final double[][] elems;
    private final int m;
    private final int n;


    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        elems = new double[m][n];
    }


    public void set(int i, int j, double s) {
        elems[i][j] = s;
    }


    public double get(int i, int j) {
        return elems[i][j];
    }


    /**
     * #prec B.m==n
     *
     * @param B
     * @return
     */

    public Matrix multiplyBy(Matrix B) {
        Matrix X = new Matrix(m, B.n);
        for (int j = 0; j < B.n; j++) {
            for (int i = 0; i < m; i++) {
                double s = 0;
                for (int k = 0; k < n; k++) {
                    s += get(i, k) * B.get(k, j);
                }
                X.set(i, j, s);
            }
        }
        return X;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer("(");
        for (int i = 0; i < m; i++) {
            sb.append("(");
            for (int j = 0; j < n; j++) {
                sb.append(elems[i][j]);
                if (j < n - 1) sb.append(", ");
            }
            sb.append(")");
        }
        sb.append(")");
        return sb.toString();
    }
}
