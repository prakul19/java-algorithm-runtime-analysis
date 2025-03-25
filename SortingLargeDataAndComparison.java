import java.util.Arrays;
import java.util.Random;

public class SortingLargeDataAndComparison {
    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int datasetSize = 10_000;
        int[] originalDataset = new int[datasetSize];

        // Generate random dataset
        for (int i = 0; i < datasetSize; i++) {
            originalDataset[i] = random.nextInt(datasetSize);
        }

        // Bubble Sort
        int[] bubbleDataset = Arrays.copyOf(originalDataset, originalDataset.length);
        long startTimeBubble = System.nanoTime();
        bubbleSort(bubbleDataset);
        long endTimeBubble = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTimeBubble - startTimeBubble) / 1_000_000 + " ms");

        // Merge Sort
        int[] mergeDataset = Arrays.copyOf(originalDataset, originalDataset.length);
        long startTimeMerge = System.nanoTime();
        mergeSort(mergeDataset);
        long endTimeMerge = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTimeMerge - startTimeMerge) / 1_000_000 + " ms");

        // Quick Sort
        int[] quickDataset = Arrays.copyOf(originalDataset, originalDataset.length);
        long startTimeQuick = System.nanoTime();
        quickSort(quickDataset, 0, quickDataset.length - 1);
        long endTimeQuick = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTimeQuick - startTimeQuick) / 1_000_000 + " ms");

        System.out.println("\nComparative Analysis:");
        System.out.println("Dataset Size: " + datasetSize);
        System.out.println("Bubble Sort Time: " + (endTimeBubble - startTimeBubble) / 1_000_000 + " ms");
        System.out.println("Merge Sort Time: " + (endTimeMerge - startTimeMerge) / 1_000_000 + " ms");
        System.out.println("Quick Sort Time: " + (endTimeQuick - startTimeQuick) / 1_000_000 + " ms");
    }
}

/*
Output:
Bubble Sort Time: 61 ms
Merge Sort Time: 1 ms
Quick Sort Time: 1 ms

Comparative Analysis:
Dataset Size: 10000
Bubble Sort Time: 61 ms
Merge Sort Time: 1 ms
Quick Sort Time: 1 ms
 */