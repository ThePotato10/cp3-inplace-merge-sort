import java.util.Arrays;

class MergeSort {
    public static int[] sort(int[] array) {
        int[] aux = new int[array.length];

        for (int i = 0; i < (array.length / 2) - 1; i++) { // runs for the number of iterations necessary to sort fully
            int mergeSize = (int) Math.pow(2, i);
 
            int insertIndex = 0;
            for (int j = 0; j < array.length; j += (mergeSize * 2)) { // loop over all elements in array

                for (int k = 0; k < mergeSize; k++) {
                    int arrIndex = j + k;

                    System.out.println("j: " + j);
                    System.out.println("k: " + k);
                    System.out.println("index 1: " + arrIndex);
                    System.out.println("index 2: " + (arrIndex + mergeSize));
                    System.out.println("Insert index: " + insertIndex);
                    System.out.println("----------");

                    if (i % 2 == 0) {// on even iterations, (incl 0) copy to aux array, on odds, copy to original array
                        aux[insertIndex] = min(array[arrIndex], array[arrIndex + (mergeSize)]);
                        aux[insertIndex + 1] = max(array[arrIndex], array[arrIndex + (mergeSize)]);

                        System.out.println("aux: " + Arrays.toString(aux));
                    } else {
                        array[insertIndex] = min(aux[arrIndex], aux[arrIndex + (mergeSize)]);
                        array[insertIndex + 1] = max(aux[arrIndex], aux[arrIndex + (mergeSize)]);

                        System.out.println("array: " + Arrays.toString(array));
                    }

                    insertIndex += 2;
                    System.out.println("----------");
                }
            }

            System.out.println("merge completed");
        }

        System.out.println("final aux: " + Arrays.toString(aux));
        System.out.println("final array: " + Arrays.toString(array));

        return aux;
    }

    public static int min(int i1, int i2) {
        if (i1 < i2) return i1;
        else return i2;
    }

    public static int max(int i1, int i2) {
        if (i1 > i2) return i1;
        else return i2;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 4, 6, 2, 7, 3, 9, 8})));
    }
}