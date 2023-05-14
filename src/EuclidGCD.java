public class EuclidGCD {
    public static void main(String[] args) {
        System.out.println(euclidGCD(14159572, 63967072));
    }
 // Наибольший общий делитель
    private static int euclidGCD(int a, int b) {
        if(a == 0) {
            return b;
        }
        if(b == 0) {
            return a;
        }
        return a >= b ? euclidGCD(a % b, b) : euclidGCD(a, b % a);
    }
}
