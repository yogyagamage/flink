package org.apache.flink.orc;

import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.RowType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class OrcSplitReaderUtillogicalTypeToOrcType_TypeDescriptionaddFieldFikaTest {

    @Test
    void testLogicalTypeToOrcTypeInvokesAddField() {
        // Create a ROW type with at least one field to trigger the addField call
        RowType rowType = (RowType) DataTypes.ROW(
                DataTypes.FIELD("field1", DataTypes.INT())
        ).getLogicalType();
        
        // This will execute the path: logicalTypeToOrcType -> case ROW -> struct.addField(...)
        OrcSplitReaderUtil.logicalTypeToOrcType(rowType);
    }
}
