package greedy_algorithms;

import java.io.FileNotFoundException;

public class GreedyBackpackRunner {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        new GreedyBackpack().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");
    }
}
