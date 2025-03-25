import java.io.*;

public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        String filePath = "largefile.txt";

        // Test FileReader performance
        try {
            long startTimeFileReader = System.nanoTime();
            readFileUsingFileReader(filePath);
            long endTimeFileReader = System.nanoTime();
            System.out.println("FileReader Time: " + (endTimeFileReader - startTimeFileReader) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("An error occurred while using FileReader: " + e.getMessage());
        }

        // Test InputStreamReader performance
        try {
            long startTimeInputStreamReader = System.nanoTime();
            readFileUsingInputStreamReader(filePath);
            long endTimeInputStreamReader = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (endTimeInputStreamReader - startTimeInputStreamReader) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("An error occurred while using InputStreamReader: " + e.getMessage());
        }
    }

    // Method to read file using FileReader
    public static void readFileUsingFileReader(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.readLine() != null) {
            }
        }
    }

    // Method to read file using InputStreamReader
    public static void readFileUsingInputStreamReader(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.readLine() != null) {
            }
        }
    }
}

/*
FileReader Time: 1542 ms
InputStreamReader Time: 1005 ms
 */