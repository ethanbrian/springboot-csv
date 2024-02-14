package org.example.controller;

import com.opencsv.exceptions.CsvValidationException;
import org.example.model.ReconciliationReport;
import org.example.model.Record;
import org.example.service.ReconciliationService;
import org.example.service.CSVReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ReconciliationReportController {

    @Autowired
    private ReconciliationService reconciliationService;

    @Autowired
    private CSVReaderService csvReaderService;

    @GetMapping("/api/reconciliation-report")
    public ReconciliationReport generateReconciliationReport() throws IOException, CsvValidationException {
        String sourceFilePath = "D:\\xampp\\htdocs\\assignment-frontend\\source.csv";
        String targetFilePath = "D:\\xampp\\htdocs\\assignment-frontend\\target.csv";

        // Read records from source and target files using CSVReaderService
        List<Record> sourceRecords = csvReaderService.readCSV(sourceFilePath);
        List<Record> targetRecords = csvReaderService.readCSV(targetFilePath);

        // Generate reconciliation report based on selected columns
        return reconciliationService.generateReconciliationReport(sourceRecords, targetRecords, null);
    }
}
