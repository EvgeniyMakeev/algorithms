package fibonacci;

import java.util.*;

public class FibonacciNumbersPisanoPeriod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int m = scan.nextInt();
        System.out.println(fibArrayDiv(n, m));
    }

    private static long fibArrayDiv(long n, int m) {
        int pisano = getPisanoPeriod(m);
        int[] arr = new int[pisano + 2];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i - 1] % m) + (arr[i - 2] % m);
            arr[i] = arr[i] % m;
        }
        System.out.println(getPisanoPeriod(m));
        System.out.println(Arrays.toString(arr));
        System.out.println(n % m);
        return arr[(int) (n % pisano)];
    }

    private static int getPisanoPeriod(int m) {
        int a = 0;
        int b = 1;
        int c;
        int limit = 1;
        for(int i = 0; i < limit; i++){
            c = (a + b) % m;
            a = b;
            b = c;
            if(a == 0 && b == 1) {
                return i + 1;
            }
            limit = limit + 1;
        }
        return -1;
    }
}

