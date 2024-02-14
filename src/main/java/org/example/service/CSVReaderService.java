package org.example.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.model.Record;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {

    public List<Record> readCSV(String filePath) throws IOException, CsvValidationException {
        List<Record> records = new ArrayList<>();

        try (Reader reader = new BufferedReader(new FileReader(filePath))) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;

            // Skip header row if necessary
             csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming the CSV structure matches the Record model
                Record record = new Record();
                record.setId(nextRecord[0]);
                record.setName(nextRecord[1]);
                record.setDate(nextRecord[2]);
                record.setAvailableBalance(Double.parseDouble(nextRecord[3]));
                record.setCharge(Double.parseDouble(nextRecord[4]));
                record.setBookBalance(Double.parseDouble(nextRecord[5]));

                records.add(record);
            }
        } catch (IOException | NumberFormatException | CsvValidationException e) {
            // Handle exceptions
            e.printStackTrace();
            throw e;
        }

        return records;
    }
}
