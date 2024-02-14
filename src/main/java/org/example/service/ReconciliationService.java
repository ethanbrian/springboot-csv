package org.example.service;

import org.example.model.Record;
import org.example.model.ReconciliationReport;

import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class ReconciliationService {

    private static final Logger logger = Logger.getLogger(ReconciliationService.class.getName());

    public ReconciliationReport generateReconciliationReport(List<Record> sourceRecords, List<Record> targetRecords, List<String> columns) {
        ReconciliationReport reconciliationReport = new ReconciliationReport();

        List<ReconciliationReport.RecordDifference> differences;
        if (columns == null || columns.isEmpty()) {
            differences = compareRecords(sourceRecords, targetRecords);
        } else {
            differences = compareRecords(sourceRecords, targetRecords, columns);
        }
        reconciliationReport.setDifferences(differences);

        // Log the differences
        logger.info("Differences: " + differences);

        return reconciliationReport;
    }

    private List<ReconciliationReport.RecordDifference> compareRecords(List<Record> sourceRecords, List<Record> targetRecords) {
        List<ReconciliationReport.RecordDifference> differences = new ArrayList<>();
        for (Record sourceRecord : sourceRecords) {
            for (Record targetRecord : targetRecords) {
                if (sourceRecord.getId().equals(targetRecord.getId())) {
                    ReconciliationReport.RecordDifference difference = compareColumns(sourceRecord, targetRecord);

                    // Log values before adding to the list
                    logger.info("Difference: " + difference);

                    differences.add(difference);
                }
            }
        }
        return differences;
    }


    private List<ReconciliationReport.RecordDifference> compareRecords(List<Record> sourceRecords, List<Record> targetRecords, List<String> columns) {
        List<ReconciliationReport.RecordDifference> differences = new ArrayList<>();
        for (Record sourceRecord : sourceRecords) {
            for (Record targetRecord : targetRecords) {
                if (sourceRecord.getId().equals(targetRecord.getId())) {
                    ReconciliationReport.RecordDifference difference = compareColumns(sourceRecord, targetRecord, columns);
                    differences.add(difference);
                }
            }
        }
        return differences;
    }


    private ReconciliationReport.RecordDifference compareColumns(Record sourceRecord, Record targetRecord) {
        ReconciliationReport.RecordDifference difference = new ReconciliationReport.RecordDifference();
        difference.setId(sourceRecord.getId());

        if (!sourceRecord.getName().equals(targetRecord.getName())) {
            difference.addDifference("Name", sourceRecord.getName(), targetRecord.getName());
        }
        // Add comparison for other columns...

        return difference;
    }


    private ReconciliationReport.RecordDifference compareColumns(Record sourceRecord, Record targetRecord, List<String> columns) {
        ReconciliationReport.RecordDifference difference = new ReconciliationReport.RecordDifference();
        difference.setId(sourceRecord.getId());

        for (String column : columns) {
            switch (column) {
                case "ID":
                    // Skip comparison for ID, as it's already compared in compareRecords method.
                    break;
                case "Name":
                    if (!sourceRecord.getName().equals(targetRecord.getName())) {
                        difference.addDifference(column, sourceRecord.getName(), targetRecord.getName());
                    }
                    break;
                // Add comparison for other specified columns...
                default:
                    logger.warning("Unknown column: " + column);
                    break;
            }
        }
        return difference;
    }
}
