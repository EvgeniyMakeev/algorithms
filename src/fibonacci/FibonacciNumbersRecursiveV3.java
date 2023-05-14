package fibonacci;

import java.util.HashMap;
import java.util.Map;

//С кэшем на HasMap для n < 93

public class FibonacciNumbersRecursiveV3 {
    private Map<Integer, Long> cache = new HashMap<>();
    private long fibRecursive(int n) {
        if (n < 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long result = fibRecursive(n - 1) + fibRecursive(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    public void run(int n) {
        System.out.println("Рекурсия V3");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
