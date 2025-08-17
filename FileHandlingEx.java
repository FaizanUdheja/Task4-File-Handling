package Task_4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingEx {
    public static void main(String[] args) {
        String inputFile = "src/products.csv";
        String outputFile = "filtered_products.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter fw = new FileWriter(outputFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());

                // Condition: price > 1000
                if (price > 1000) {
                    fw.write(name + "," + price + "\n");
                }
            }
            System.out.println("Filtered products written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
