package org.apache.flink.runtime.shuffle;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

class NettyShuffleUtilsgetMinMaxFloatingBuffersPerInputGate_PairofFikaTest {

    @Test
    void testGetMinMaxFloatingBuffersPerInputGate() {
        int numFloatingBuffersPerGate = 10;
        Pair<Integer, Integer> result = NettyShuffleUtils.getMinMaxFloatingBuffersPerInputGate(numFloatingBuffersPerGate);
    }
}
