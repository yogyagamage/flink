package org.apache.flink.orc.vector;

import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrcLegacyTimestampColumnVectorcreateFromConstant_LongColumnVectormethodFikaTest {

    @Test
    public void testCreateFromConstant() {
        int batchSize = 5;
        Object value = Timestamp.valueOf("2023-01-01 12:00:00");
        
        ColumnVector result = OrcLegacyTimestampColumnVector.createFromConstant(batchSize, value);
    }
}
