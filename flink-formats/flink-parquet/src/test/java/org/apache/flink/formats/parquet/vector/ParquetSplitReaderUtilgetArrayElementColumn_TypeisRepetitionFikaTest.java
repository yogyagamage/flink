package org.apache.flink.formats.parquet.vector;

import org.apache.parquet.io.ColumnIO;
import org.apache.parquet.io.GroupColumnIO;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.Type;
import org.apache.parquet.schema.Type.Repetition;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParquetSplitReaderUtilgetArrayElementColumn_TypeisRepetitionFikaTest {

    @Test
    public void testGetArrayElementColumn() {
        // Create a mock GroupColumnIO that will trigger the while loop condition
        GroupColumnIO mockGroupColumnIO = mock(GroupColumnIO.class);
        GroupColumnIO mockChildGroupColumnIO = mock(GroupColumnIO.class);
        
        // Create mock Type for the parent columnIO
        Type mockType = mock(Type.class);
        when(mockGroupColumnIO.getType()).thenReturn(mockType);
        when(mockType.isRepetition(Repetition.REPEATED)).thenReturn(false);
        
        // Set up the parent-child relationship
        when(mockGroupColumnIO.getChild(0)).thenReturn(mockChildGroupColumnIO);
        
        // Create mock Type for the child columnIO
        Type mockChildType = mock(Type.class);
        when(mockChildGroupColumnIO.getType()).thenReturn(mockChildType);
        when(mockChildType.isRepetition(Repetition.REPEATED)).thenReturn(true);
        
        // Call the entry point method
        ParquetSplitReaderUtil.getArrayElementColumn(mockGroupColumnIO);
    }
}
