package huffman_coding;

import java.io.FileNotFoundException;

public class HuffmanCodingRunner {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        new HuffmanCoding().run();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms\n");
    }
}
