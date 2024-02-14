package org.example.model;

import java.util.List;

public class ReconciliationReport {
    private List<RecordDifference> differences;

    public List<RecordDifference> getDifferences() {
        return differences;
    }


    public void setDifferences(List<RecordDifference> differences) {
        this.differences = differences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reconciliation Report:\n");
        if (differences != null) {
            for (RecordDifference difference : differences) {
                sb.append(difference.toString()).append("\n");
            }
        } else {
            sb.append("No differences found.");
        }
        return sb.toString();
    }

    public static class RecordDifference {
        private String type;
        private String recordIdentifier;
        private String field;
        private String sourceValue;
        private String targetValue;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        private String id;



        // Modified addDifference method to accept a list parameter
        public void addDifference(String field, String sourceValue, String targetValue) {
            this.field = field; // Set the field that has the difference
            this.sourceValue = sourceValue; // Set the value from the source record
            this.targetValue = targetValue; // Set the value from the target record

        }



        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRecordIdentifier() {
            return recordIdentifier;
        }

        public void setRecordIdentifier(String recordIdentifier) {
            this.recordIdentifier = recordIdentifier;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getSourceValue() {
            return sourceValue;
        }

        public void setSourceValue(String sourceValue) {
            this.sourceValue = sourceValue;
        }

        public String getTargetValue() {
            return targetValue;
        }

        public void setTargetValue(String targetValue) {
            this.targetValue = targetValue;
        }

        @Override
        public String toString() {
            // Customize the string representation of RecordDifference if needed
            return "RecordDifference{" +
                    "type='" + type + '\'' +
                    ", recordIdentifier='" + recordIdentifier + '\'' +
                    ", field='" + field + '\'' +
                    ", sourceValue='" + sourceValue + '\'' +
                    ", targetValue='" + targetValue + '\'' +
                    '}';
        }
    }
}
