package com.ydfind.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * zip解压示例
 *
 * @author : ydfind
 * @date : 2019-06-06
 */
@Slf4j
public class ZipUtil {

    public static void main(String[] args) throws IOException {
    }

    /**
     * 从zip的inputStream中读出map<文件名，内容>
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static Map<String, String> readZipByInputStream(InputStream inputStream) throws IOException {
        Map<String, String> map = new HashMap<String, String >(8);
        ZipInputStream zip;
        zip = new ZipInputStream(inputStream);
        ZipEntry zipEntry = null;
        while((zipEntry = zip.getNextEntry()) != null){
            String filename = zipEntry.getName();
            if(zipEntry.isDirectory()){
                if(FileUtils.isDirEnd(filename)) {
                    filename += "\\";
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byteTemp = new byte[1024];
            int num = -1;
            while((num = zip.read(byteTemp,0,byteTemp.length))>-1){
                byteArrayOutputStream.write(byteTemp,0,num);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            String content = new String(bytes,"UTF-8");
            map.put(filename, content);
        }
        return map;
    }

    public static void unZip(String sourceFilename, String targetDir) throws IOException {
        unZip(new File(sourceFilename), targetDir);
    }

    /**
     * 将sourceFile解压到targetDir
     * @param sourceFile
     * @param targetDir
     * @throws RuntimeException
     */
    public static void unZip(File sourceFile, String targetDir) throws IOException {
        long start = System.currentTimeMillis();
        if (!sourceFile.exists()) {
            throw new FileNotFoundException("cannot find the file = " + sourceFile.getPath());
        }
        ZipFile zipFile = null;
        try{
            zipFile = new ZipFile(sourceFile);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (entry.isDirectory()) {
                    String dirPath = targetDir + "/" + entry.getName();
                    FileUtils.createDirIfNotExist(dirPath);
                } else {
                    File targetFile = new File(targetDir + "/" + entry.getName());
                    FileUtils.createFileIfNotExist(targetFile);
                    InputStream is = null;
                    FileOutputStream fos = null;
                    try {
                        is = zipFile.getInputStream(entry);
                        fos = new FileOutputStream(targetFile);
                        int len;
                        byte[] buf = new byte[1024];
                        while ((len = is.read(buf)) != -1) {
                            fos.write(buf, 0, len);
                        }
                    }finally {
                        try{
                            fos.close();
                        }catch (Exception e){
                            log.warn("close FileOutputStream exception", e);
                        }
                        try{
                            is.close();
                        }catch (Exception e){
                            log.warn("close InputStream exception", e);
                        }
                    }
                }
            }
            log.info("解压完成，耗时：" + (System.currentTimeMillis() - start) +" ms");
        } finally {
            if(zipFile != null){
                try {
                    zipFile.close();
                } catch (IOException e) {
                    log.warn("close zipFile exception", e);
                }
            }
        }
    }

}
