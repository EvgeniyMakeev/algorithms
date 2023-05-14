package number_of_inversions;

import java.io.IOException;

public class MergeSortAlgRunner {
    public static void main(String[] args) throws IOException {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        new MergeSortAlgV1().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new MergeSortAlgV2().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");
    }
}
