package org.apache.flink.runtime.jobmaster.event;

import org.junit.jupiter.api.Test;
import org.apache.flink.runtime.scheduler.strategy.ExecutionVertexID;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.List;

public class ExecutionVertexResetEventtoString_StringUtilsjoinFikaTest {

    @Test
    public void testToStringInvokesStringUtilsJoin() {
        ExecutionVertexID vertex1 = new ExecutionVertexID(new org.apache.flink.runtime.jobgraph.JobVertexID(), 0);
        ExecutionVertexID vertex2 = new ExecutionVertexID(new org.apache.flink.runtime.jobgraph.JobVertexID(), 1);
        List<ExecutionVertexID> vertexIds = Arrays.asList(vertex1, vertex2);
        
        ExecutionVertexResetEvent event = new ExecutionVertexResetEvent(vertexIds);
        event.toString();
    }
}
