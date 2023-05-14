package editing_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Алгоритм вычисления редакционного расстояния (расстояния Левенштейна) динамическое программирование
public class EditingDistanceV2 {
    private String first;
    private String second;
    private int[][] cache;
    private boolean[][] calculated;

    // рекурсивный метод, но с добавленной меморизацией (ленивый алгоритм) в виде массива, вычисления редакционного расстояния
    private int editingDistance(int n, int m) {
        // берем символы из строк first[0...n - 1], second[0...m - 1]
        if (n == 0 && m == 0) {
            return 0;
        } else if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        } else if (calculated[n][m]) {
            return cache[n][m];
        } else {
            int resInsert = editingDistance(n, m - 1) + 1;
            int resDelete = editingDistance(n - 1, m) + 1;
            int resChange = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
            int result = Math.min(resInsert, Math.min(resDelete, resChange));
            calculated[n][m] = true;
            cache[n][m] = result;
            return result;
        }
    }

    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input4.txt"));
        first = input.nextLine();
        second = input.nextLine();
        input.close();
        cache = new int[first.length() + 1][second.length() + 1];
        calculated = new boolean[first.length() + 1][second.length() + 1];

        System.out.println("Расстояние Левенштейна рекурсивный метод с меморизацией:");
        System.out.println(first + "\n" + second);
        System.out.println(editingDistance(first.length(), second.length()));

    }
}
