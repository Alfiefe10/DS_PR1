package edu.uoc.ds.samples.module4;

public class RecursiveSamples {

    public static boolean isEven(int n) {
        boolean res;
        if (n == 0)
            res = true;
        else {
            // (**) recursive call
            res = isEven(n - 1);
            res = !res;
            // (**) calculate result from recursive call
        }
        return res;
    }


    public static int mcd(int x, int y) {
        int res;
        if (x == y)
            res = x;
        else {
            if (x > y)
                res = mcd(x - y, y);
            else
                res = mcd(y - x, x);
        }
        // res is the greatest common divisor of x and y
        return res;
    }
}
