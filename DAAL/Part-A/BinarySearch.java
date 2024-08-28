public class BinarySearch {

    // Function to perform binary search
    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if key is present at mid
            if (array[mid] == key)
                return mid;

            // If key is greater, ignore the left half
            if (array[mid] < key)
                left = mid + 1;

            // If key is smaller, ignore the right half
            else
                right = mid - 1;
        }

        // Key not found
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 10, 40 };
        int key = 10;

        int result = binarySearch(array, key);

        if (result == -1)
            System.out.println("Element not present in the array");
        else
            System.out.println("Element found at index " + result);
    }
}
