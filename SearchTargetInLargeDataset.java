import java.util.Arrays;
import java.util.Random;

public class SearchTargetInLargeDataset {
    // Linear Search method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found
    }

    // Binary Search method
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Return the index if the target is found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        Random random = new Random();
        int datasetSize = 1_000_000;
        int[] dataset = new int[datasetSize];

        // Generate random dataset
        for (int i = 0; i < datasetSize; i++) {
            dataset[i] = random.nextInt(datasetSize);
        }

        int target = dataset[random.nextInt(datasetSize)]; // Random target value

        // Measure Linear Search time
        long startTimeLinear = System.nanoTime();
        int linearIndex = linearSearch(dataset, target);
        long endTimeLinear = System.nanoTime();
        long durationLinear = endTimeLinear - startTimeLinear;

        // Sort the dataset for Binary Search
        Arrays.sort(dataset);

        // Measure Binary Search time
        long startTimeBinary = System.nanoTime();
        int binaryIndex = binarySearch(dataset, target);
        long endTimeBinary = System.nanoTime();
        long durationBinary = endTimeBinary - startTimeBinary;

        System.out.println("Linear Search:");
        System.out.println("Index found: " + linearIndex);
        System.out.println("Time taken: " + durationLinear / 1_000_000 + " ms");

        System.out.println("\nBinary Search:");
        System.out.println("Index found: " + binaryIndex);
        System.out.println("Time taken: " + durationBinary / 1_000_000 + " ms");

        System.out.println("\nComparative Analysis:");
        System.out.println("Dataset Size: " + datasetSize);
        System.out.println("Linear Search Time: " + durationLinear / 1_000_000 + " ms");
        System.out.println("Binary Search Time: " + durationBinary / 1_000_000 + " ms");
    }
}

/*
Output:
Linear Search:
Index found: 145004
Time taken: 1 ms

Binary Search:
Index found: 307889
Time taken: 0 ms

Comparative Analysis:
Dataset Size: 1000000
Linear Search Time: 1 ms
Binary Search Time: 0 ms
 */