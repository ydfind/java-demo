package com.ydfind.prjprocess;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public interface PrjCodeHelper {
    /**
     * 解密
     * @param filename
     * @return
     */
    String getDecryptFilename(String filename);

    /**
     * 加密
     * @param filename
     * @return
     */
    String getEncryptFilename(String filename);

    /**
     * 解密
     * @param content
     * @return
     */
    String getDecryptContent(String content);

    /**
     * 加密
     * @param content
     * @return
     */
    String getEncryptContent(String content);

    /**
     * 解密
     * @param dirname
     * @return
     */
    String getDecryptDirname(String dirname);

    /**
     * 加密
     * @param dirname
     * @return
     */
    String getEncryptDirname(String dirname);
}
