package com.ydfind.kafka.report.model;

import lombok.Data;

import java.io.Serializable;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class ReportData implements Serializable{

    private String userId;

    private String createTime;

    private String page;

    private String operate;

    private ReportMetaData metaData;

    @Override
    public String toString() {
        return "ReportData{" +
                "userId='" + userId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", page='" + page + '\'' +
                ", operate='" + operate + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
