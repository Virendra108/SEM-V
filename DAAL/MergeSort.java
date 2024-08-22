public class MergeSort {

    // Function to merge two subarrays
    public static void merge(int[] array, int left, int middle, int right) {
        // Sizes of two subarrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Function to divide the array into subarrays and sort them
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Sort first and second halves
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Main function to test the merge sort
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        
        System.out.println("Original array:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        
        sort(array, 0, array.length - 1);
        
        System.out.println("\n\nSorted array:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
