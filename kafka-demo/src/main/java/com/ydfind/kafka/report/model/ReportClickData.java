package com.ydfind.kafka.report.model;

import lombok.Data;

import java.io.Serializable;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class ReportClickData implements Serializable {

    private String tagType;

    private String content;

    @Override
    public String toString() {
        return "ReportClickData{" +
                "tagType='" + tagType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
