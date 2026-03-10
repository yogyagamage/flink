package org.apache.flink.orc.shim;

import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.orc.RecordReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class OrcShimV210nextBatch_RecordReadernextBatchFikaTest {

    @Test
    void testNextBatch() throws IOException {
        OrcShimV210 shim = new OrcShimV210();
        
        RecordReader recordReader = new SimpleRecordReader();
        VectorizedRowBatch rowBatch = new VectorizedRowBatch(0);
        
        shim.nextBatch(recordReader, rowBatch);
    }
    
    static class SimpleRecordReader implements RecordReader {
        public boolean nextBatch(VectorizedRowBatch rowBatch) throws IOException {
            return false;
        }
        
        public void close() throws IOException {
        }
        
        public boolean hasNext() throws IOException {
            return false;
        }
        
        public Object next(Object previous) throws IOException {
            return null;
        }
        
        public long getRowNumber() throws IOException {
            return 0;
        }
        
        public float getProgress() throws IOException {
            return 0;
        }
        
        public void seekToRow(long rowCount) throws IOException {
        }
        
        public long getNumberOfRows() {
            return 0;
        }
        
        public Object getSchema() {
            return null;
        }
        
        public Object getRowIndex() {
            return null;
        }
        
        public boolean isInclude() {
            return false;
        }
        
        public void setInclude(boolean[] include) {
        }
    }
}
