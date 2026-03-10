package org.apache.flink.orc;

import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.types.logical.ArrayType;
import org.apache.flink.table.types.logical.CharType;
import org.apache.flink.table.types.logical.DecimalType;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.MapType;
import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.table.types.logical.VarCharType;
import org.apache.orc.TypeDescription;
import org.junit.jupiter.api.Test;

public class OrcSplitReaderUtillogicalTypeToOrcType_TypeDescriptioncreateMapFikaTest {

    @Test
    public void testLogicalTypeToOrcTypeInvokesCreateMap() {
        OrcSplitReaderUtil util = new OrcSplitReaderUtil();
        
        LogicalType keyType = DataTypes.INT().getLogicalType();
        LogicalType valueType = DataTypes.STRING().getLogicalType();
        MapType mapType = new MapType(keyType, valueType);
        
        util.logicalTypeToOrcType(mapType);
    }
}
