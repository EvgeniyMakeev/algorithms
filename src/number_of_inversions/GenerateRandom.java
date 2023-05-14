package number_of_inversions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateRandom {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input3.txt");
        int n = 10000;
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        printWriter.println(n);
        for (int i = 0; i < n; i++) {
            builder.append(random.nextInt()).append(" ");
        }
        printWriter.print(builder);
        printWriter.close();
    }
}
