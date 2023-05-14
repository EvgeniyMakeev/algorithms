package fibonacci;

// Динамическое программирование назад или ДМ сверху вниз
// Горазда быстрее обычной рекурсии за счёт использования Мемонизации, сохраняя значения в массив

import java.util.Arrays;

public class FibonacciNumbersRecursiveTD {
    int[] fibArr;

    private int fibRecursiveTD(int n) {
        if (fibArr[n] == -1) {
            if (n < 2) {
                fibArr[n] = n;
            } else {
                fibArr[n] = fibRecursiveTD(n - 1) + fibRecursiveTD(n - 2);
            }
            return fibArr[n];
        }
        return fibArr[n];
    }
    public void run(int n) {
        fibArr = new int[n + 1];
        Arrays.fill(fibArr,-1);
        System.out.println("Динамическое программирование назад");
        System.out.println(n + " = " + fibRecursiveTD(n));
    }
}

