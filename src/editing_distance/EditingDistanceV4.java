package editing_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Алгоритм вычисления редакционного расстояния (расстояния Левенштейна) динамическое программирование
// избавляемся от кэша для экономии памяти
// Нельзя будет восстановить ответ!!

public class EditingDistanceV4 {
    private String first;
    private String second;
    private int[] cur;
    private int[] prev;


    private int editingDistance(String first, String second) {
        for (int n = 0; n <= first.length(); n++) {
            for (int m = 0; m <= second.length(); m++) {
                if (n == 0 && m == 0) {
                    cur[m] = 0;
                } else {
                    int result = Integer.MAX_VALUE;
                    if (m > 0) {
                        result = Math.min(result, cur[m - 1] + 1);
                    }
                    if (n > 0) {
                        result = Math.min(result, prev[m] + 1);
                    }
                    if (n > 0 && m > 0) {
                        result = Math.min(result, prev[m - 1] + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1));
                    }
                    cur[m] = result;
                }
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
        return prev[second.length()];
    }


    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input4.txt"));
        first = input.nextLine();
        second = input.nextLine();
        input.close();
        cur = new int[second.length() + 1];
        prev = new int[second.length() + 1];

        System.out.println("Расстояние Левенштейна итеративный метод с меморизацией без вывода ответа:");
        System.out.println(first + "\n" + second);
        System.out.println(editingDistance(first, second));

    }
}
