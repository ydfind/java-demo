package com.ydfind.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.Objects;

/**
 * Excel类
 * @author ydfind
 * @date 2019.10.12
 */
@Slf4j
public class ExcelReadWrite {

    /**
     * 通过复制格子的形式，作为读写的例子
     * 将excel文件sourceFilename的内容，复制到targetFilename
     * @param sourceFilename
     * @param targetFilename
     */
    public static void copyExcel(String sourceFilename, String targetFilename) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try{
            log.info("start to copy excel from {} to {}", sourceFilename, targetFilename);
            // 源文件
            File inFile = new File(sourceFilename);
            inputStream = new FileInputStream(inFile);
            Workbook inWork = new HSSFWorkbook(inputStream);
            // 目标
            File outFile = new File(targetFilename);
            outputStream = new FileOutputStream(outFile);
            Workbook outWork = new HSSFWorkbook();
            // 复制
            copyExcel(inWork, outWork);
            // 保存到目标文件
            outWork.write(outputStream);
            log.info("copy success");
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                }catch (Exception e){
                    log.warn("outputStream close error!");
                }
            }
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    log.warn("inputStream close error!");
                }
            }
        }
    }

    private static void copyExcel(Workbook source, Workbook target){
        // 遍历复制
        int sheetCount = source.getNumberOfSheets();
        for(int i = 0; i < sheetCount; i++){
            Sheet inSheet = source.getSheetAt(i);
            Sheet outSheet = target.createSheet(inSheet.getSheetName());
            int rowCount = inSheet.getLastRowNum() + 1;
            for(int j = 0; j < rowCount; j++){
                Row inRow = inSheet.getRow(j);
                Row outRow = outSheet.createRow(j);
                if(Objects.isNull(inRow)){
                    continue;
                }
                int colNum = inRow.getLastCellNum() + 1;
                for(int coli = 0; coli < colNum; coli++){
                    Cell inCell = inRow.getCell(coli);
                    Cell outCell = outRow.createCell(coli);
                    if(Objects.isNull(inCell)){
                        continue;
                    }
                    String text = inCell.toString();
                    if(Objects.isNull(text)){
                        continue;
                    }
                    outCell.setCellValue(text.trim());
                }
            }
        }
    }
}
