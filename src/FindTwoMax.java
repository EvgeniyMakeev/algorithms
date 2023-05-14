public class FindTwoMax {
    public static void main(String[] args) {
        int[] array = {1, 2, 6, 8, 12, 26, 31, 32, 33, 48, 56, 59, 64, 88};
        findTwoMax(array);
    }

    public static void findTwoMax(int[] arrayToSearch) {
        int max1 = Math.max(arrayToSearch[0], arrayToSearch[1]);
        int max2 = Math.min(arrayToSearch[0], arrayToSearch[1]);
        for (int i = 2; i < arrayToSearch.length; i++) {
            if (arrayToSearch[i] > max1) {
                max2 = max1;
                max1 = arrayToSearch[i];
            } else if (arrayToSearch[i] > max2) {
                max2 = arrayToSearch[i];
            }
        }
        System.out.println("Max1 = " + max1 + "\nMax2 = " + max2);
    }
}
