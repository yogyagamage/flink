package org.apache.flink.orc;

import org.apache.hadoop.hive.ql.io.sarg.SearchArgument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class Andadd_BuilderstartAndFikaTest {

    @Test
    public void testAddCallsStartAnd() {
        // Create mock predicates array (required for constructor)
        OrcFilters.Predicate[] mockPredicates = new OrcFilters.Predicate[0];
        
        // Create instance of And using constructor
        OrcFilters.And andInstance = new OrcFilters.And(mockPredicates);
        
        // Create mock builder that will return itself when startAnd() is called
        SearchArgument.Builder mockBuilder = mock(SearchArgument.Builder.class);
        Mockito.when(mockBuilder.startAnd()).thenReturn(mockBuilder);
        Mockito.when(mockBuilder.end()).thenReturn(mockBuilder);
        
        // Call the entry point method - this should trigger startAnd() on the mock
        andInstance.add(mockBuilder);
    }
}
