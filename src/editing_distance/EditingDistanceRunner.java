package editing_distance;

import java.io.FileNotFoundException;

public class EditingDistanceRunner {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime;
        long endTime;

//        startTime = System.currentTimeMillis();
//        new EditingDistanceV1().run();
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");

//        startTime = System.currentTimeMillis();
//        new EditingDistanceV2().run();
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new EditingDistanceV3().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new EditingDistanceV3_1().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");

        startTime = System.currentTimeMillis();
        new EditingDistanceV4().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");
    }
}
