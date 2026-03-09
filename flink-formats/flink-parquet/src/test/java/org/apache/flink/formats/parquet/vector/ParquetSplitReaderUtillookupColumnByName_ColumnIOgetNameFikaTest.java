package org.apache.flink.formats.parquet.vector;

import org.apache.parquet.io.ColumnIO;
import org.apache.parquet.io.GroupColumnIO;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParquetSplitReaderUtillookupColumnByName_ColumnIOgetNameFikaTest {

    @Test
    public void testLookupColumnByName() {
        ParquetSplitReaderUtil util = new ParquetSplitReaderUtil();
        
        GroupColumnIO groupColumnIO = mock(GroupColumnIO.class);
        ColumnIO columnIO = mock(ColumnIO.class);
        
        when(groupColumnIO.getChild("testColumn")).thenReturn(null);
        when(groupColumnIO.getChildrenCount()).thenReturn(1);
        when(groupColumnIO.getChild(0)).thenReturn(columnIO);
        when(columnIO.getName()).thenReturn("TESTCOLUMN");
        
        ParquetSplitReaderUtil.lookupColumnByName(groupColumnIO, "testColumn");
    }
}
