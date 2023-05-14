package number_of_inversions;

import java.io.*;
import java.util.Arrays;

public class MergeSortAlgV1 {
    // Сортировка слиянием - Слияние
    private int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int[] result = new int[arr1.length + arr2.length];
        for (int k = 0; k < result.length; k++) {
            if (j == arr2.length || (i < arr1.length && arr1[i] <= arr2[j])) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
        }
        return result;
    }

    // Сортировка слиянием - Сортировка
    private int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            int n = arr.length;
            int m = n / 2;
            int[] left = new int[m];
            int[] right = new int[n - m];
            System.arraycopy(arr, 0, left, 0, m);
            System.arraycopy(arr, m, right, 0, n - m);
            left = mergeSort(left);
            right = mergeSort(right);
            return merge(left, right);
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
        int[] arr = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        input.close();
        System.out.println(Arrays.toString(arr));
        int[] sortedArr = mergeSort(arr);

        // проверим сортировку
//        for (int i = 0; i < sortedArr.length - 1; i++) {
//            if (sortedArr[i] > sortedArr[i + 1]) {
//                throw new RuntimeException();
//            }
//        }
        System.out.println(Arrays.toString(sortedArr));
    }
}
