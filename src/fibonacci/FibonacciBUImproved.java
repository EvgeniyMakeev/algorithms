package fibonacci;

// Динамическое программирование назад или ДМ сверху вниз O(n^2)
// без использования массива и рекурсии - есть меньше памяти

public class FibonacciBUImproved {
    private int fibBUImproved(int n) {
            if (n < 2) {
                return n;
            } else {
                int prev = 0;
                int curr = 1;
                for (int i = 1; i < n; i++) {
                    int next = prev + curr;
                    prev = curr;
                    curr = next;
                }
                return curr;
            }
    }
    public void run(int n) {
        System.out.println("Динамическое программирование назад без массива и рекурсии");
        System.out.println(n + " = " + fibBUImproved(n));
    }
}

