package org.apache.flink.runtime.metrics;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.junit.jupiter.api.Test;

class CommonMetricsSnapshotevaluate_StandardDeviationmethodFikaTest {

    @Test
    void testEvaluate() throws MathIllegalArgumentException {
        DescriptiveStatisticsHistogramStatistics.CommonMetricsSnapshot snapshot =
                new DescriptiveStatisticsHistogramStatistics.CommonMetricsSnapshot();
        
        double[] values = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        snapshot.evaluate(values, 0, values.length);
    }
}
