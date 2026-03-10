package org.apache.flink.runtime.metrics;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class DescriptiveStatisticsHistogramStatistics_CommonMetricsSnapshotmaybeInitPercentile_PercentilewithNaNStrategyFikaTest {

    @Test
    public void testGetValuesTriggersWithNaNStrategy() {
        DescriptiveStatisticsHistogram.CircularDoubleArray mockArray = Mockito.mock(DescriptiveStatisticsHistogram.CircularDoubleArray.class);
        double[] testValues = new double[]{1.0, 2.0, 3.0};
        when(mockArray.toUnsortedArray()).thenReturn(testValues);

        DescriptiveStatisticsHistogramStatistics statistics = new DescriptiveStatisticsHistogramStatistics(mockArray);
        statistics.getValues();
    }
}
