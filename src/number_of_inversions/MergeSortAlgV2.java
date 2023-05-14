package number_of_inversions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// Для экономии памяти сокращаем количество массивов.

public class MergeSortAlgV2 {

    // Временный массив для всех методов
    private int[] temp;
    private int[] arr;

    // Сортировка слиянием - Слияние

    // результат будет в том же массиве
    private void merge(int l, int m , int r) {
        // arr[l...m - 1] arr[m...r - 1] -> temp[l...r - 1] -> res[l...r - 1]
        int i = l;
        int j = m;
        for (int k = l; k < r; k++) {
            if (j == r || (i < m && arr[i] <= arr[j])) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
        }
        System.arraycopy(temp, l, arr, l, r - l);
    }

    // Сортировка слиянием - Сортировка
    private void mergeSort(int l, int r) {
        if (r <= l + 1) {
        } else {
            // arr[l...r - 1] -> arr[l...m - 1] arr[m...r - 1]

            // >> 1 - побитовый сдвиг - деление на 2
            int m = (l + r) >> 1;
            mergeSort(l, m);
            mergeSort(m, r);
            merge(l, m, r);
        }
    }

    public void run() throws IOException {
//        Scanner input = new Scanner(new File("input3.txt"));
//        int n = input.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = input.nextInt();
//        }

        // Buffer работает быстрее
        BufferedReader input = new BufferedReader(new FileReader("input3.txt"));
        int n = Integer.parseInt(input.readLine());
        arr = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        input.close();
        System.out.println(Arrays.toString(arr));
        temp = new int[n];
        mergeSort(0, n);

        // проверим сортировку
//        for (int i = 0; i < sortedArr.length - 1; i++) {
//            if (sortedArr[i] > sortedArr[i + 1]) {
//                throw new RuntimeException();
//            }
//        }
        System.out.println(Arrays.toString(arr));
    }
}
