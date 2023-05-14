import java.util.Arrays;

// Сортировка подсчётом

public class SortByCounting {
    public static void main(String[] args) {
        int[] array = {5,4,5,3,2,1,5};
        int k = 5; // диапазон элементов массива
        System.out.println(Arrays.toString(sortCoting(array, k)));
    }

    public static int[] sortCoting(int[] arrayToSearch, int k) {
        // создаем целочисленный массив размером `k + 1` для хранения счетчика каждого целого числа
        // во входном массиве
        int[] freq = new int[k + 1];

        // используя значение каждого элемента входного массива в качестве индекса,
        // сохраняем счетчик каждого целого числа в `freq[]`
        for (int i: arrayToSearch) {
            freq[i]++;
        }

        // перезаписываем входной массив в порядке сортировки
        int index = 0;
        for (int i = 0; i <= k; i++)
        {
            while (freq[i]-- > 0) {
                arrayToSearch[index++] = i;
            }
        }
        return arrayToSearch;
    }
}
