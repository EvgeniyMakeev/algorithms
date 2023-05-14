package fibonacci;

//для n > 93 ест вычисление по модулю ещё быстрее.

public class FibonacciNumbersRecursiveV8 {
    private static final int MOD = (int) (1e9+7);

    private int fibRecursive(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n ; i++) {
            int c = (a + b) % MOD;
            // a, b <- b, c
            a = b;
            b = c;
         }
        return a;
    }

    public void run(int n) {
        System.out.println("Рекурсия V8");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
