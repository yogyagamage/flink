package org.apache.flink.orc;

import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.types.logical.ArrayType;
import org.apache.flink.table.types.logical.LogicalType;
import org.junit.jupiter.api.Test;
import org.apache.orc.TypeDescription;

public class OrcSplitReaderUtillogicalTypeToOrcType_TypeDescriptioncreateListFikaTest {

    @Test
    public void testLogicalTypeToOrcTypeInvokesCreateList() {
        OrcSplitReaderUtil util = new OrcSplitReaderUtil();
        
        LogicalType arrayType = new ArrayType(
            DataTypes.INT().getLogicalType()
        );
        
        util.logicalTypeToOrcType(arrayType);
    }
}
