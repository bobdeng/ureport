package com.bstek.ureport.chart.dataset.impl.category;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.utils.DataUtils;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cn.bobdeng.testtools.SnapshotMatcher.snapshotMatch;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryDatasetTest {
    @Test
    void Given_When_Then() {
        MockedStatic<DataUtils> dataUtilsMockedStatic = Mockito.mockStatic(DataUtils.class);
        Cell cell = new Cell();
        String datasetName = "test";
        List values = Arrays.asList(
                new TestData("分组1", "1", "11"),
                new TestData("分组2", "1", "21"),
                new TestData("分组2", "2", "22"),
                new TestData("分组3", "1", "31"),
                new TestData("分组4", "1", "41"),
                new TestData("分组4", "2", "42")
        );
        dataUtilsMockedStatic.when(() -> DataUtils.fetchData(cell, null, datasetName))
                .thenReturn(values);
        CategoryDataset categoryDataset = new BarDataset();
        categoryDataset.setDatasetName(datasetName);
        categoryDataset.setCategoryProperty("group");
        categoryDataset.setSeriesProperty("serial");
        categoryDataset.setValueProperty("value");
        categoryDataset.setSeriesType(SeriesType.property);
        String json = categoryDataset.buildDatasetJson(null, cell, null);
        assertThat("[" + json + "]", snapshotMatch(this, "has_empty"));
    }
}
