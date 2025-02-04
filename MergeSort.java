import java.util.Arrays;

class MergeSort {
    public static int[] sort(int[] array) {
        int[] aux = new int[array.length];

        for (int i = 0; i < (array.length / 2) - 1; i++) { // runs for the number of iterations necessary to sort fully
            int mergeSize = (int) Math.pow(2, i);

            for (int j = 0; j < array.length; j += (mergeSize * 2)) { // loop over all elements in array
                if (i % 2 == 0) { // on even rounds, copy to aux array
                    System.out.println("Indexes: " + Arrays.toString(new int[]{j, j + mergeSize - 1, j + mergeSize, j + (mergeSize * 2) - 1}));

                    merge(j, j + mergeSize - 1, j + mergeSize, j + (mergeSize * 2) - 1, array, aux);
                    System.out.println("Merge completed: " + Arrays.toString(aux));
                } else {
                    System.out.println("Indexes: " + Arrays.toString(new int[]{j, j + mergeSize - 1, j + mergeSize, j + (mergeSize * 2) - 1}));

                    merge(j, j + mergeSize - 1, j + mergeSize, j + (mergeSize * 2) - 1, aux, array);
                    System.out.println("Merge completed: " + Arrays.toString(array));
                }

            }

            System.out.println("merge completed");
        }

        return aux;
    }

    public static void merge(int leftStart, int leftEnd, int rightStart, int rightEnd, int[] arr, int[] sorted) {
        int sortedIndex = leftStart;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                sorted[sortedIndex] = arr[leftStart];
                leftStart++;
                sortedIndex++;
    
            } else {
                sorted[sortedIndex] = arr[rightStart];
                rightStart++;
                sortedIndex++;
    
            }
        }
    
        if (leftStart <= leftEnd) {
            for (int i = leftStart; i <= leftEnd; i++) {
                sorted[sortedIndex] = arr[i];
                sortedIndex++;
            }
        }
    
        if (rightStart <= rightEnd) {
            for (int i = rightStart; i <= rightEnd; i++) {
                sorted[sortedIndex] = arr[i];
                sortedIndex++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{4, 1, 6, 2, 7, 3, 9, 8})));
    }
}