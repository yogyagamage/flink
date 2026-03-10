package org.apache.flink.orc;

import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.ql.io.sarg.PredicateLeaf;
import org.apache.hadoop.hive.ql.io.sarg.SearchArgument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.Serializable;
import java.math.BigDecimal;

public class NullSafeEquals_ColumnPredicatecastLiteral_HiveDecimalWritablemethodFikaTest {

    @Test
    public void testAddMethodTriggersHiveDecimalWritableConstructor() {
        // Create a mock SearchArgument.Builder
        SearchArgument.Builder mockBuilder = Mockito.mock(SearchArgument.Builder.class);
        
        // Create parameters for NullSafeEquals constructor
        String columnName = "decimalColumn";
        PredicateLeaf.Type literalType = PredicateLeaf.Type.DECIMAL;
        Serializable literal = new BigDecimal("123.45");
        
        // Instantiate NullSafeEquals using the provided constructor
        OrcFilters.NullSafeEquals nullSafeEquals = new OrcFilters.NullSafeEquals(
            columnName, 
            literalType, 
            literal
        );
        
        // Call the entry point method
        nullSafeEquals.add(mockBuilder);
    }
}
