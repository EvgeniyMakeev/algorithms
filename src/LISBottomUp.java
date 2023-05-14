// Нахождение наибольшей последовательнократной возростающей подпоследовательности O(n^2)

import java.util.Arrays;

public class LISBottomUp {
    public static void main(String[] args) {
        int[] arr = {1, 1, 6, 2, 8, 3, 5, 4, 5, 7, 12, 10};
        System.out.println(lisBottomUp(arr));
    }

    private static int lisBottomUp(int[] arr) {
        int[] d = new int[arr.length];
        int[] prev = new int[arr.length];
        // заполняем массив со всеми максимальными длинами последовательностей заканчивающимися на каждом элементе массива arr
        for (int i = 0; i < d.length; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && (d[j] + 1) > d[i]) {
                    // новая максимальная длина последовательности
                    d[i] = d[j] + 1;
                    // записываем индекс предидущего элемента этой последовательности
                    prev[i] = j;
                }
            }
        }
        int ans = 0;
        // находим максимальную длину последовательности
        for (int i = 0; i < d.length; i++) {
            ans = Math.max(ans, d[i]);
        }

        // восстанавливаем ответ с самой наибольшей последовательнократностью подпоследовательность
        int[] longestSequence = new int[ans];
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (d[i] > d[k]) {
                k = i;
            }
        }
        int j = ans -1;
        while (k >= 0) {
            longestSequence[j] = arr[k];
            j--;
            k = prev[k];
        }

//        // восстанавливаем ответ с наибольшая последовательнократной подпоследовательность без массива prev (НУЖНО ДОДЕЛАТЬ!)
//        int[] longestSequence = new int[ans];
//        int l = ans - 1;
//        while (l > 0) {
//            for (int i = d.length - 1; i > 0; i--) {
//                if (d[i] > d[i - 1]) {
//                    if (arr[d[i]] > arr[d[i - 1]]) {
//                        longestSequence[l] = arr[i];
//                        l--;
//                    }
//                } else {
//                    longestSequence[l] = arr[0];
//                }
//            }
//        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(prev));

        System.out.println(Arrays.toString(longestSequence));

        return ans;
    }
}
