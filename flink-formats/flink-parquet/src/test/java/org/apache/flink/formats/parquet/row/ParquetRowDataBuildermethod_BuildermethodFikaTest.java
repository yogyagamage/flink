package org.apache.flink.formats.parquet.row;

import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.VarCharType;
import org.apache.parquet.io.OutputFile;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ParquetRowDataBuildermethod_BuildermethodFikaTest {

    @Test
    public void testBuilderConstructorChain() throws IOException {
        // Create mock OutputFile required for ParquetRowDataBuilder constructor
        OutputFile mockOutputFile = Mockito.mock(OutputFile.class);
        
        // Create a simple RowType required for constructor
        RowType rowType = RowType.of(
            new LogicalType[]{new VarCharType(255)},
            new String[]{"testField"}
        );
        
        // Create instance using the entry point constructor
        // This should trigger the chain to ParquetWriter.Builder constructor
        ParquetRowDataBuilder builder = new ParquetRowDataBuilder(
            mockOutputFile,
            rowType,
            false
        );
    }
}
