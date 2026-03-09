package org.apache.flink.formats.parquet.avro;

import org.apache.avro.reflect.ReflectData;
import org.junit.jupiter.api.Test;

class AvroParquetWritersforReflectRecord_ReflectDatagetSchemaFikaTest {

    @Test
    void testForReflectRecordCallsReflectDataGetSchema() {
        // The entry point is a static method, so no instance is needed
        // We just need to call it with a concrete class to trigger the chain
        AvroParquetWriters.forReflectRecord(TestRecord.class);
    }

    // Simple test class to use as the type parameter
    private static class TestRecord {
        private String field1;
        private int field2;
        
        public String getField1() {
            return field1;
        }
        
        public void setField1(String field1) {
            this.field1 = field1;
        }
        
        public int getField2() {
            return field2;
        }
        
        public void setField2(int field2) {
            this.field2 = field2;
        }
    }
}
