package fibonacci;

public class FibonacciNumbersArray {
    // Более быстрый алгоритм
    // Динамическое программирование вперед или ДМ снизу вверх
    private int fibArray(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
    public void run(int n) {
        System.out.println("Массив");
        System.out.println(n + " = " + fibArray(n));
    }
}
