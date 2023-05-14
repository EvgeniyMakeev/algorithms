// Можно ли из цифр одно числа сделать другое

public class Numbers {
    public static void main(String[] args) {
        int n = 2021;
        int x = 1220;
        System.out.println(possibleOrNot(n, x));
    }

    private static boolean possibleOrNot(int n, int x) {
        int[] arrN = new int[10];
        int[] arrX = new int[10];
        while (x > 0){
            arrN[n % 10] += 1;
            arrX[x % 10] += 1;
            n /= 10;
            x /= 10;
        }
        for (int i : arrN) {
            if(arrN[i] != arrX[i]) {
                return false;
            }
        }
        return true;
    }
}
