package fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

//С кэшем на HasMap для n > 93 от меньшего к большему сокращая число рекурсивных вызовов(чтобы не было переполнения стека).

public class FibonacciNumbersRecursiveV5 {
    private Map<Integer, BigInteger> cache = new HashMap<>();

    private BigInteger fibRecursive(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            for (int i = 2; i <= n; i++) {
                BigInteger result = fibRecursive(i - 1).add(fibRecursive(i - 2));
                cache.put(i, result);
            }
            return cache.get(n);
        }
    }

    public void run(int n) {
        System.out.println("Рекурсия V5");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
