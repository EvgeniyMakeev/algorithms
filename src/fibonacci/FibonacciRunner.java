package fibonacci;

public class FibonacciRunner {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        int n = 30;

        startTime = System.currentTimeMillis();
        new FibonacciNumbersRecursiveV1().run(n);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

//        startTime = System.currentTimeMillis();
//        new FibonacciNumbersRecursiveV2().run(n);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");
//
//        startTime = System.currentTimeMillis();
//        new FibonacciNumbersRecursiveV3().run(92);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");

//        startTime = System.currentTimeMillis();
//        new FibonacciNumbersRecursiveV4().run(n);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");

//        startTime = System.currentTimeMillis();
//        new FibonacciNumbersRecursiveV5().run(n);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");
//
//        startTime = System.currentTimeMillis();
//        new FibonacciNumbersRecursiveV6().run(n);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");
//
//        startTime = System.currentTimeMillis();
//        new FibonacciNumbersRecursiveV7().run(n);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");
//
        startTime = System.currentTimeMillis();
        new FibonacciNumbersRecursiveV8().run(n);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new FibonacciNumbersArray().run(n);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new FibonacciNumbersRecursiveTD().run(n);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new FibonacciBUImproved().run(n);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");
    }
}
