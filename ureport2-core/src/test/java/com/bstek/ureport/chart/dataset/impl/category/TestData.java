package com.bstek.ureport.chart.dataset.impl.category;

import lombok.Data;

@Data
public class TestData {
    private String group;
    private String serial;
    private String value;

    public TestData(String group, String serial, String value) {
        this.group = group;
        this.serial = serial;
        this.value = value;
    }
}
