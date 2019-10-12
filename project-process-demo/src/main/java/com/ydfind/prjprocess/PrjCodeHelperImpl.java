package com.ydfind.prjprocess;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class PrjCodeHelperImpl implements PrjCodeHelper {
    @Override
    public String getDecryptFilename(String filename) {
        return filename.replace(".csv", "");
    }

    @Override
    public String getEncryptFilename(String filename) {
        return filename + ".csv";
    }

    @Override
    public String getDecryptContent(String content) {
        return content;
    }

    @Override
    public String getEncryptContent(String content) {
        return content;
    }

    @Override
    public String getDecryptDirname(String dirname) {
        return dirname.replace("-csv", "");
    }

    @Override
    public String getEncryptDirname(String dirname) {
        return dirname + "-csv";
    }
}
