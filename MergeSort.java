// By JD Peppelman, 2-4-25
// Implements an iterative merge sort algorithm that runs in O(n log(n)) time and has a constant space complexity

import java.util.Arrays;

class MergeSort {
    public static int[] sort(int[] array) {
        int[] aux = new int[array.length];

        for (int i = 0; i < (int) (Math.log(array.length) / Math.log(2)) + 1; i++) { // runs for the number of iterations necessary to sort fully
            int mergeSize = (int) Math.pow(2, i); // mergeSize doubles every iteration

            for (int j = 0; j < array.length; j += (mergeSize * 2)) { // loop over all elements in array
                if (i % 2 == 0) { // on even rounds, copy to aux array
                    merge(j, j + mergeSize - 1, j + mergeSize, j + (mergeSize * 2) - 1, array, aux);

                } else { // on odd rounds, copy to original array
                    merge(j, j + mergeSize - 1, j + mergeSize, j + (mergeSize * 2) - 1, aux, array);

                }
            }
        }

        return aux;
    }

    // Helper method to merge two chunks of ints from arr into sorted
    private static void merge(
        int leftStart, int leftEnd, 
        int rightStart, int rightEnd, 
        int[] arr, 
        int[] sorted
    ) {
        int sortedIndex = leftStart;

        // prevent IndexOutOfBounds errors 
        if (leftEnd >= arr.length) leftEnd = arr.length - 1;
        if (rightEnd >= arr.length) rightEnd = arr.length - 1;

        while (leftStart <= leftEnd && rightStart <= rightEnd) { // While still traversing both chunks, add the smallest element not yet traversed
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
    

        // After at least one chunk is traversed, add all remaining elements not yet written to new array
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
        System.out.println(Arrays.toString(sort(new int[]{118, 183, 63, 122, 78, 58, 180, 102, 145, 174, 14, 50, 172, 92, 55, 186, 50, 149, 189, 124, 12, 18, 43, 15, 156, 163, 125, 192, 12, 64, 191, 118, 75, 43, 99, 80, 99, 124, 60, 2, 42, 197, 21, 32, 76, 156, 55, 18, 66, 159, 119, 121, 192, 167, 48, 68, 97, 0, 199, 192, 100, 100, 87, 74, 96, 189, 172, 19, 124, 131, 57, 120, 190, 158, 185})));
    }
}