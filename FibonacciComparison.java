import java.util.Scanner;

public class FibonacciComparison {
    // Recursive approach
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative approach
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the value of n for Fibonacci computation: ");
            int n = scanner.nextInt();

            // Measure time for recursive approach
            long startTimeRecursive = System.nanoTime();
            int resultRecursive = fibonacciRecursive(n);
            long endTimeRecursive = System.nanoTime();
            System.out.println("Recursive Fibonacci:");
            System.out.println("Fibonacci(" + n + ") = " + resultRecursive);
            System.out.println("Time taken: " + (endTimeRecursive - startTimeRecursive) / 1_000_000.0 + " ms");

            // Measure time for iterative approach
            long startTimeIterative = System.nanoTime();
            int resultIterative = fibonacciIterative(n);
            long endTimeIterative = System.nanoTime();
            System.out.println("\nIterative Fibonacci:");
            System.out.println("Fibonacci(" + n + ") = " + resultIterative);
            System.out.println("Time taken: " + (endTimeIterative - startTimeIterative) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

/*
Input:
Enter the value of n for Fibonacci computation: 30
Output:
Recursive Fibonacci:
Fibonacci(30) = 832040
Time taken: 5.869583 ms

Iterative Fibonacci:
Fibonacci(30) = 832040
Time taken: 0.001958 ms
*/