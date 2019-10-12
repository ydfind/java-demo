package com.ydfind.kafka.report.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class ReportMetaData implements Serializable {

    private String title;

    private List<ReportClickData> clickData = new ArrayList<>();

    @Override
    public String toString() {
        return "ReportMetaData{" +
                "title='" + title + '\'' +
                ", clickData=" + clickData +
                '}';
    }
}
