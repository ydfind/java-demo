package com.ydfind.ignite.example1;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * 类
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class Class
{
    @QuerySqlField(index = true)
    private int id;

    @QuerySqlField
    private String name;

    private int level;

    public Class(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class [id=" + id + ", name=" + name + ", level=" + level + "]";
    }
}
