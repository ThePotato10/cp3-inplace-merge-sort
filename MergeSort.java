import java.util.Arrays;

class MergeSort {
    public static int[] sort(int[] array) {
        int[] sorted = new int[array.length];

        //for (int i = 0; i < (array.length / 2) + 1; i++) { // runs for the number of iterations necessary to sort fully
            int mergeSize = (0 * 2) + 1;

            for (int j = 0; j < array.length; j += mergeSize) { // loop over all elements in array
                for (int k = 0; k < mergeSize; k++) { // loop over elements to merge in each subdivision
                    int arrIndex = j + k;

                    sorted[arrIndex] = min(array[arrIndex], array[arrIndex + (mergeSize * 2)]);
                }
            }
        //}

        return sorted;
    }

    public static int min(int i1, int i2) {
        if (i1 < i2) return i1;
        else return i2;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 4, 6, 2, 7, 3, 9, 8})));
    }
}