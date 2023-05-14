package fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//С кэшем на ArrayList для n > 93 ест меньше памяти и быстрее.

public class FibonacciNumbersRecursiveV6 {
    private List<BigInteger> cache = new ArrayList<>();

    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }

    private BigInteger fibRecursive(int n) {
        // 0...cache.size - 1
        // cache.size...n
        for (int i = cache.size(); i <= n ; i++) {
            BigInteger result = cache.get(i - 1).add(cache.get(i - 2));
            cache.add(result);
        }
        return cache.get(n);
    }

    public void run(int n) {
        System.out.println("Рекурсия V6");
        System.out.println(n + " = " + fibRecursive(n));
    }
}
