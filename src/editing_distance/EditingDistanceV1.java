package editing_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Алгоритм вычисления редакционного расстояния (расстояния Левенштейна) динамическое программирование
public class EditingDistanceV1 {
    private String first;
    private String second;

    // рекурсивный метод вычисления редакционного расстояния ооочень медленно
    private int editingDistance(int n, int m) {
        // берем символы из строк first[0...n - 1], second[0...m - 1]
        if (n == 0 && m == 0) {
            return 0;
        } else if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        } else {
            int resInsert = editingDistance(n, m - 1) + 1;
            int resDelete = editingDistance(n - 1, m) + 1;
            int resChange = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
            return Math.min(resInsert, Math.min(resDelete, resChange));
        }
    }

    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input4.txt"));
        first = input.nextLine();
        second = input.nextLine();
        input.close();
        System.out.println("Расстояние Левенштейна рекурсивный метод:");
        System.out.println(first + "\n" + second);
        System.out.println(editingDistance(first.length(), second.length()));

    }
}
