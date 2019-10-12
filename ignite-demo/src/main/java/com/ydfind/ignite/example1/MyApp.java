package com.ydfind.ignite.example1;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;

import java.util.List;

/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class MyApp
{
    public static void main(String[] args)
    {
        Ignite ignite = Ignition.start();
        CacheConfiguration<Integer, Class> classCfg = new CacheConfiguration<Integer, Class>();
        classCfg.setName("CLA");
        classCfg.setCacheMode(CacheMode.PARTITIONED);
        classCfg.setIndexedTypes(Integer.class, Class.class);
        IgniteCache<Integer, Class> classCache = ignite.getOrCreateCache(classCfg);
        classCache.put(1, new Class(1, "五年级一班"));
        classCache.put(2, new Class(2, "五年级二班"));

        CacheConfiguration<Integer, Student> stuCfg = new CacheConfiguration<Integer, Student>();
        stuCfg.setName("STU");
        stuCfg.setCacheMode(CacheMode.PARTITIONED);
        stuCfg.setIndexedTypes(Integer.class, Student.class);
        IgniteCache<Integer, Student> stuCache = ignite.getOrCreateCache(stuCfg);
        stuCache.put(1, new Student(1, "张三", 10));
        stuCache.put(2, new Student(1, "李四", 11));
        stuCache.put(3, new Student(2, "王五", 11));
        stuCache.put(4, new Student(2, "胜七", 10));

        SqlFieldsQuery sql = new SqlFieldsQuery(
                "select concat(stu.classId, '----', stu.name) as stuinfo"
                        + " "
                        + "from Student as stu "
                        + "");

        QueryCursor<List<?>> cursor = stuCache.query(sql);
        for (List<?> row : cursor)
        {
            System.out.println("学生信息：" + row.get(0));
        }

        SqlFieldsQuery sql1 = new SqlFieldsQuery(
                "select concat(cla.id, '----', cla.name) as clainfo"
                        + ", concat(stu.name, '----', stu.age) as stuinfo "
                        + "from Class as cla, STU.Student as stu "
                        + "where cla.id = stu.classId");

        QueryCursor<List<?>> cursor1 = classCache.query(sql1);
        for (List<?> row : cursor1)
        {
            System.out.println("班级信息：" + row.get(0) + ", 学生信息：" + row.get(1));
        }
    }
}
