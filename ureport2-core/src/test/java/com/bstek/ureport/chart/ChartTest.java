package com.bstek.ureport.chart;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.chart.dataset.impl.category.BarDataset;
import com.bstek.ureport.model.Cell;
import org.junit.jupiter.api.Test;

import static cn.bobdeng.testtools.SnapshotMatcher.snapshotMatch;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

class ChartTest {
    @Test
    void Given_When_Then() {
        Chart chart = new Chart();
        chart.setDataset(new BarDataset());
        Cell cell = new Cell();
        cell.setName("单元格名称");
        Context context = mock(Context.class);
        ChartData chartData = chart.doCompute(cell, context);
        assertThat(chartData.getJson(), snapshotMatch(this, "empty"));
    }
}
