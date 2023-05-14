public class FindMax {
    public static void main(String[] args) {
        int[] array = {1,2,6,8,12,26,31,32,33,48,56,59,64,38};
        System.out.println(array[FindMax(array)]);
    }

    public static int FindMax(int[] arrayToSearch) {
        int max = arrayToSearch.length - 1;
        for (int i = arrayToSearch.length - 2; i >= 0; i--) {
        if (arrayToSearch[i] > arrayToSearch[max]) {
            max = i;
            }
        }
        return max;
    }
}
