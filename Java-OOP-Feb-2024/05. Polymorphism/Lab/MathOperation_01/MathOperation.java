package polymorphism.MathOperation_01;

public class MathOperation {
    public int add(int a, int b) {
        return this.add(a + b);
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public int add(int... params) {
        int res = 0;

        for (int param : params) {
           res += param;
        }

        return res;
    }
}
