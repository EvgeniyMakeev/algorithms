package fibonacci;

// Очень медленно для n < 47

public class FibonacciNumbersRecursiveV1 {
    private int fibRecursive(int n) {
        return n < 2 ? n : fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    public void run(int n) {
        System.out.println("Рекурсия V1");
        System.out.println(n + " = " + fibRecursive(n));
    }
}

