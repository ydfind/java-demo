package com.ydfind.util;


import java.io.*;
/**
 * Object类 试验
 * @author ydfind
 * @date 2019.10.12
 */
public class ObjectUtils {

    public static void writeObjectToFile(Object obj, String filename) throws IOException {
        FileUtils.createFileIfNotExist(new File(filename));
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
    }

    public static Object readObjectFromFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj= ois.readObject();
        return obj;
    }
}
