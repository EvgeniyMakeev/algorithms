package fibonacci;

import java.util.ArrayList;
import java.util.List;

//С кэшем на ArrayList для n > 93 ест вычисление по модулю.

public class FibonacciNumbersRecursiveV7 {
    private static final int MOD = (int) (1e9+7);
    private List<Integer> cache = new ArrayList<>();

    {
        cache.add(0);
        cache.add(1);
    }

    private int fibRecursive(int n) {
        for (int i = cache.size(); i <= n ; i++) {
            int result = (cache.get(i - 1) + cache.get(i - 2)) % MOD;
            cache.add(result);
        }
        return cache.get(n);
    }

    public void run(int n) {
        System.out.println("Рекурсия V7");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
