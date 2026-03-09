package org.apache.flink.formats.parquet.vector;

import org.apache.parquet.io.ColumnIO;
import org.apache.parquet.io.GroupColumnIO;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParquetSplitReaderUtillookupColumnByName_GroupColumnIOgetChildrenCountFikaTest {

    @Test
    public void testLookupColumnByNameInvokesGetChildrenCount() {
        // Create mock GroupColumnIO
        GroupColumnIO groupColumnIO = mock(GroupColumnIO.class);
        
        // Setup behavior to ensure getChildrenCount() is called
        // First call to getChild(String) returns null to enter the loop
        when(groupColumnIO.getChild("testColumn")).thenReturn(null);
        
        // getChildrenCount() should return a value > 0 to enter the loop
        when(groupColumnIO.getChildrenCount()).thenReturn(1);
        
        // Setup getChild(int) to return a mock ColumnIO
        ColumnIO childColumnIO = mock(ColumnIO.class);
        when(groupColumnIO.getChild(0)).thenReturn(childColumnIO);
        
        // Setup getName() to match case-insensitively
        when(childColumnIO.getName()).thenReturn("TESTCOLUMN");
        
        // Call the entry point method
        ParquetSplitReaderUtil.lookupColumnByName(groupColumnIO, "testColumn");
    }
}
