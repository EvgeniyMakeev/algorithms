package editing_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Алгоритм вычисления редакционного расстояния (расстояния Левенштейна) динамическое программирование
// Убрали рекурсию для скорости
// Убрали дублирующийся код

public class EditingDistanceV3_1 {
    private int[][] cache;
    boolean[][] firstMove;
    boolean[][] secondMove;
    private int editingDistance(String first, String second) {
        for (int n = 0; n <= first.length(); n++) {
            for (int m = 0; m <= second.length(); m++) {
                if (n == 0 && m == 0) {
                    cache[n][m] = 0;
                } else if (n == 0) {
                    secondMove[n][m] = true;
                    cache[n][m] = m;
                } else if (m == 0) {
                    firstMove[n][m] = true;
                    cache[n][m] = n;
                } else {
                    int resInsert = cache[n][m - 1] + 1;
                    int resDelete = cache[n - 1][m] + 1;
                    int resChange = cache[n - 1][m - 1] + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
                    int result;
                    if (resInsert <= resDelete && resInsert <= resChange) {
                        secondMove[n][m] = true;
                        result = resInsert;
                    } else if (resDelete <= resChange) {
                        firstMove[n][m] = true;
                        result = resDelete;
                    } else {
                        firstMove[n][m] = true;
                        secondMove[n][m] = true;
                        result = resChange;
                    }
                    cache[n][m] = result;
                }
            }
        }
        return cache[first.length()][second.length()];
    }


    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input4.txt"));
        String first = input.nextLine();
        String second = input.nextLine();
        input.close();

        int n = first.length();
        int m = second.length();
        cache = new int[n + 1][m + 1];
        firstMove = new boolean[n + 1][m + 1];
        secondMove = new boolean[n + 1][m + 1];

        System.out.println("Расстояние Левенштейна итеративный метод с меморизацией и выводом ответа:");
        System.out.println(first + "\n" + second);
        System.out.println(editingDistance(first, second));


        // вывод строк с результатом правок
        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();

        while (n > 0 || m > 0) {
            boolean mf = firstMove[n][m];
            boolean ms = secondMove[n][m];
            if (mf) {
                firstLine.insert(0, first.charAt(n - 1));
                n--;
            } else {
                firstLine.insert(0,"-");
            }
            if (ms) {
                secondLine.insert(0, second.charAt(m - 1));
                m--;
            } else {
                secondLine.insert(0,"-");
            }
        }

        System.out.println(firstLine + "\n" + secondLine);
    }
}
