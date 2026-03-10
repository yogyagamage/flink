package org.apache.flink.orc.vector;

import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrcTimestampColumnVectorcreateFromConstant_TimestampColumnVectorfillFikaTest {

    @Test
    public void testCreateFromConstantInvokesFill() {
        int batchSize = 5;
        LocalDateTime localDateTime = LocalDateTime.now();
        
        ColumnVector result = OrcTimestampColumnVector.createFromConstant(batchSize, localDateTime);
    }
}
