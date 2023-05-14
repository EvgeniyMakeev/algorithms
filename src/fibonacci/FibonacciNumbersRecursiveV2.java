package fibonacci;

import java.util.HashMap;
import java.util.Map;

//С кэшем на HasMap для n < 47
public class FibonacciNumbersRecursiveV2 {
    private Map<Integer, Integer> cache = new HashMap<>();
    private int fibRecursive(int n) {
        if (n < 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int result = fibRecursive(n - 1) + fibRecursive(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    public void run(int n) {
        System.out.println("Рекурсия V2");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
