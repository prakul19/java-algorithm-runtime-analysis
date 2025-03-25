public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int iterations = 1_000_000; // Number of concatenations
        String text = "hello";

        // Using String
        long startTimeString = System.nanoTime();
        String stringResult = "";
        for (int i = 0; i < iterations; i++) {
            stringResult += text; // Creates a new object every time
        }
        long endTimeString = System.nanoTime();
        System.out.println("String concatenation time: " + (endTimeString - startTimeString) / 1_000_000 + " ms");

        // Using StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text); // Efficient due to mutability
        }
        long endTimeBuilder = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTimeBuilder - startTimeBuilder) / 1_000_000 + " ms");

        // Using StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text); // Thread-safe, slightly slower
        }
        long endTimeBuffer = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTimeBuffer - startTimeBuffer) / 1_000_000 + " ms");

        System.out.println("\nComparative Analysis:");
        System.out.println("String concatenation time: " + (endTimeString - startTimeString) / 1_000_000 + " ms");
        System.out.println("StringBuilder concatenation time: " + (endTimeBuilder - startTimeBuilder) / 1_000_000 + " ms");
        System.out.println("StringBuffer concatenation time: " + (endTimeBuffer - startTimeBuffer) / 1_000_000 + " ms");
    }
}


/*
String concatenation time: 118061 ms
StringBuilder concatenation time: 11 ms
StringBuffer concatenation time: 31 ms

Comparative Analysis:
String concatenation time: 118061 ms
StringBuilder concatenation time: 11 ms
StringBuffer concatenation time: 31 ms
*/