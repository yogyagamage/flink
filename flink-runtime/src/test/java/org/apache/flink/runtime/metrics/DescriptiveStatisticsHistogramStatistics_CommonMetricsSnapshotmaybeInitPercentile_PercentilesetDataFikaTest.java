package org.apache.flink.runtime.metrics;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.flink.runtime.metrics.DescriptiveStatisticsHistogramStatistics.CommonMetricsSnapshot;
import org.junit.jupiter.api.Test;

class DescriptiveStatisticsHistogramStatistics_CommonMetricsSnapshotmaybeInitPercentile_PercentilesetDataFikaTest {

    @Test
    void testGetValuesTriggersPercentileSetData() {
        // Create a non-null double array to avoid NPE in constructor
        double[] values = new double[]{1.0, 2.0, 3.0};
        
        // Create instance using constructor that accepts double[]
        DescriptiveStatisticsHistogramStatistics instance = 
            new DescriptiveStatisticsHistogramStatistics(values);
        
        // Call entry point method to trigger the chain
        instance.getValues();
    }
}
