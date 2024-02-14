package  org.example;
import org.example.model.Record;
import org.example.model.ReconciliationReport;
import org.example.service.ReconciliationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Paths to the CSV files
        String sourceCSV = "D:\\xampp\\htdocs\\assignment-frontend\\source.csv";
        String targetCSV = "D:\\xampp\\htdocs\\assignment-frontend\\target.csv";

        // Read records from CSV files
        List<Record> sourceRecords = readCSV(sourceCSV);
        List<Record> targetRecords = readCSV(targetCSV);

        // Initialize the reconciliation service
        ReconciliationService reconciliationService = new ReconciliationService();

        // Generate reconciliation report
        ReconciliationReport reconciliationReport = reconciliationService.generateReconciliationReport(sourceRecords, targetRecords, null);

        // Log the differences
        List<ReconciliationReport.RecordDifference> differences = reconciliationReport.getDifferences();
        for (ReconciliationReport.RecordDifference difference : differences) {
            // Log each difference
            System.out.println("Difference: " + difference);
        }
    }

    // Method to read records from a CSV file
    private static List<Record> readCSV(String filePath) {
        List<Record> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine(); // This will read and discard the first line (header)

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // Assuming the CSV format matches the Record class
                Record record = new Record(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
                records.add(record);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
        return records;
    }

}
