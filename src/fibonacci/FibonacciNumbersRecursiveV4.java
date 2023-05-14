package fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

//С кэшем на HasMap для n > 93

public class FibonacciNumbersRecursiveV4 {
    private Map<Integer, BigInteger> cache = new HashMap<>();
    private BigInteger fibRecursive(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            BigInteger result = fibRecursive(n - 1).add(fibRecursive(n - 2));
            cache.put(n, result);
            return result;
        }
    }

    public void run(int n) {
        System.out.println("Рекурсия V4");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
