import java.util.Arrays;

// Заполнение рюкзака
// Динамическое программирование

public class Backpack {
    public static void main(String[] args) {
        int wTotal = 10;
        // нужно добавить 0 элемент в массивы
        int[] weights = {0, 6, 3, 4, 2};
        int[] costs = {0, 30, 14, 16, 9};
        System.out.println(backpackWithRepsBU(wTotal, weights, costs));
        System.out.println(backpackWithoutRepsBU(wTotal, weights, costs));

    }


    // Можно повторять элементы (снизу вверх) O(nW)
    private static int backpackWithRepsBU(int wTotal, int[] weights, int[] costs) {
        int[] d = new int[wTotal + 1];
        Arrays.fill(d, 0);
        for (int w = 1; w < d.length; w++) {
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] <= w) {
                    d[w] = Math.max(d[w], d[w - weights[i]] + costs[i]);
                }
            }
        }
        return d[wTotal];
    }

    // Нельзя повторять элементы (снизу вверх) O(nW)
    private static int backpackWithoutRepsBU(int wTotal, int[] weights, int[] costs) {
        int[][] d = new int[wTotal + 1][costs.length];
        for (int i = 1; i < costs.length; i++) {
            for (int w = 0; w < d.length; w++) {
                d[w][i] = d[w][i - 1];
                if (weights[i] <= w) {
                    d[w][i] = Math.max(d[w][i], d[w - weights[i]][i - 1] + costs[i]);
                }
            }
        }
        printArr(d);
        return d[wTotal][weights.length - 1];
    }
    private static void printArr(int[][] field) {
        for (int i = 0; i < field.length ; i++) {  //идём по строкам
            for (int j = 0; j < field[i].length; j++) { //идём по столбцам
                System.out.print(field[i][j] + " "); //вывод элемента
            }
            System.out.println();
        }
    }


}
