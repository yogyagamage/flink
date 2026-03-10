package org.apache.flink.orc;

import org.apache.flink.orc.OrcFilters.Not;
import org.apache.flink.orc.OrcFilters.Predicate;
import org.apache.hadoop.hive.ql.io.sarg.SearchArgument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Notadd_BuilderstartNotFikaTest {

    @Test
    void testAddCallsStartNot() {
        Predicate mockPredicate = Mockito.mock(Predicate.class);
        SearchArgument.Builder mockBuilder = Mockito.mock(SearchArgument.Builder.class);
        SearchArgument.Builder mockNotBuilder = Mockito.mock(SearchArgument.Builder.class);
        
        Mockito.when(mockBuilder.startNot()).thenReturn(mockNotBuilder);
        Mockito.when(mockPredicate.add(mockNotBuilder)).thenReturn(mockBuilder);
        
        Not not = new Not(mockPredicate);
        not.add(mockBuilder);
    }
}
