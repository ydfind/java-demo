package com.ydfind.prjprocess;

import com.ydfind.util.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Slf4j
public class PrjCodeProcesser {
    private static PrjCodeHelper prjCodeHelper = new PrjCodeHelperImpl();

    public static final String FILE_END_ZIP = ".zip";
    public static final String FILE_END_RAR = ".rar";
    private static final String FILE_SEPERATE_1 = "/";
    private static final String FILE_SEPERATE_2 = "\\";

    private static void encryptFile(String source, String target) throws IOException {
        if(source.endsWith(FILE_END_ZIP) || source.endsWith(FILE_END_RAR)){
        }else {
            FileUtils.writeFile(target, FileUtils.readFile(source));
            File file = new File(source);
            file.delete();
        }
    }

    private static void encryptDir(String source, String target) throws IOException {
        File sourceDirRoot = new File(source);
        File[] subFiles = sourceDirRoot.listFiles();
        for(File file: subFiles){
            if(file.isFile()){
                encryptFile(file.getPath(), target + FILE_SEPERATE_1 + prjCodeHelper.getEncryptFilename(file.getName()));
            }else if(file.isDirectory()){
                encryptDir(file.getPath(), target + FILE_SEPERATE_1 + file.getName());
            }
        }
    }

    public static void encryptPrj(String source, String target) throws IOException {
        File sourceDir = new File(source);
        String newTarget = target;
        String newSource = source;
        if(sourceDir.isFile()){
            if(newTarget == null){
                newTarget = prjCodeHelper.getEncryptFilename(source);
            }
            encryptFile(newSource, newTarget);
        } else if(sourceDir.isDirectory()){
            if(newSource.endsWith(FILE_SEPERATE_1) || newSource.endsWith(FILE_SEPERATE_2)){
                newSource = newSource.substring(0, newSource.length() - 1);
            }
            if(newTarget == null){
                newTarget = prjCodeHelper.getEncryptDirname(newSource);
            } else if(newTarget.endsWith(FILE_SEPERATE_1) || newTarget.endsWith(FILE_SEPERATE_2)){
                newTarget = newTarget.substring(0, newTarget.length() - 1);
            }
            encryptDir(newSource, newTarget);
        } else {
            log.error("source need to be a file or a directory!");
        }
    }

    private static void decryptFile(String source, String target) throws IOException {
        FileUtils.writeFile(target, FileUtils.readFile(source));
    }

    private static void decryptDir(String source, String target) throws IOException {
        File sourceDirRoot = new File(source);
        File[] subFiles = sourceDirRoot.listFiles();
        for(File file: subFiles){
            if(file.isFile()){
                decryptFile(file.getPath(), target + "/" + prjCodeHelper.getDecryptFilename(file.getName()));
            }else if(file.isDirectory()){
                decryptDir(file.getPath(), target + "/" + file.getName());
            }
        }
    }

    public static void decryptPrj(String source, String target) throws IOException {
        File sourceDir = new File(source);
        String newTarget = target;
        String newSource = source;
        if(sourceDir.isFile()){
            if(newTarget == null){
                newTarget = prjCodeHelper.getDecryptFilename(source);
            }
            decryptFile(newSource, newTarget);
        } else if(sourceDir.isDirectory()){
            if(newSource.endsWith(FILE_SEPERATE_1) || newSource.endsWith(FILE_SEPERATE_2)){
                newSource = newSource.substring(0, newSource.length() - 1);
            }
            if(newTarget == null){
                newTarget = prjCodeHelper.getDecryptDirname(newSource);
            } else if(newTarget.endsWith(FILE_SEPERATE_1) || newTarget.endsWith(FILE_SEPERATE_2)){
                newTarget = newTarget.substring(0, newTarget.length() - 1);
            }
            decryptDir(newSource, newTarget);
        } else {
            log.error("source need to be a file or a directory!");
        }
    }
}
