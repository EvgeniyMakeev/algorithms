public class BinarySearchAlg {
    public static void main(String[] args) {
        int[] array = {1,2,6,8,12,26,31,32,48,48,48,48,64,88};
        int element = 48;
        System.out.println(binarySearch(array,element));
        System.out.println(leftBinarySearch(0, array.length - 1, array, 48));
        System.out.println(rightBinarySearch(0, array.length - 1, array, 48));

    }

    public static int binarySearch(int[] arrayToSearch, int element) {
        int elementPos = -1;
        int lowIndex = 0;
        int highIndex = arrayToSearch.length - 1;
        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (element == arrayToSearch[midIndex]) {
                elementPos = midIndex;
                break;
            } else if (element < arrayToSearch[midIndex]) {
                highIndex = midIndex - 1;
            } else if (element > arrayToSearch[midIndex]) {
                lowIndex = midIndex + 1;
            }
        }
        return elementPos;
    }

    // Всё было плох и стало хорошо. Найти когда стало хорошо
    public static int leftBinarySearch(int l, int r, int[] arr, int x) {
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    // Всё было хорошо и стало плохо. Найти последнее хорошо
    public static int rightBinarySearch(int l, int r, int[] arr, int x) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (arr[m] <= x) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}