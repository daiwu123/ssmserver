package com.wu.util;

import com.wu.m.SelfStatus;
import com.wu.util.canno.ExcelMark;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

@Component
public class ExcelUtil extends BaseExcelUtil {
    /**
     * 描述:
     *
     * @param '' return
     *           Author Dai Wu
     *           Date 2019/12/24 15:17
     **/
    public <T> List<T> excelToListT(Class<T> c, String fileName, int sheetIndex, InputStream in) throws IOException, InstantiationException, IllegalAccessException {
        Workbook workbook = this.getWorkbook(fileName, in);
        if (workbook == null || c == null) {
            System.out.println("请检查当前类型,或者文件名称");
        } else {
            return generateData(c, sheetIndex, workbook);
        }
        return null;
    }

    ;


    public <T> void export(Class<T> c, List<T> source, String fileName, ServletOutputStream out) throws IOException, IllegalAccessException {
        Workbook workbook = this.getWorkbook(fileName);
        if (workbook != null) {
            Sheet sheet = workbook.createSheet();
            List<String> excelCol = new ArrayList<>();
            List<Field> curExcelvaildField = new ArrayList<>();
            Field[] tFields = c.getDeclaredFields();
            for (int i = 0; i < tFields.length; i++) {
                Field curField = tFields[i];
                curField.setAccessible(true);
                ExcelMark annotation = curField.getAnnotation(ExcelMark.class);
                if (annotation != null) {
                    String markCol = annotation.excelColName();
                    if (markCol != null && !markCol.equals("")) {
                        excelCol.add(markCol);
                        curExcelvaildField.add(curField);
                    }
                }
            }
            if (!excelCol.isEmpty()) {
                //创建表头
                Row titleRow = sheet.createRow(0);
                for (int i = 0; i < excelCol.size(); i++) {
                    String title = excelCol.get(i);
                    // Field cur_Field = curExcelvaildField.get(i);
                    Cell cell = titleRow.createCell(i);
                    cell.setCellValue(title);
                }
            } else {
                return;
            }
            for (int i = 0; i < source.size(); i++) {
                T single_obj = source.get(i);
                Row cur_row = sheet.createRow(i + 1);
                for (int j = 0; j < curExcelvaildField.size(); j++) {
                    String strValue = "";
                    Field cur_Field = curExcelvaildField.get(j);
                    Cell cur_cell = cur_row.createCell(j);
                    Object value = cur_Field.get(single_obj);
                    if(value!=null){
                        strValue = value+"";
                    }
                    cur_cell.setCellValue(strValue);
                }
            }
            workbook.write(out);
            out.flush();
            out.close();

        }
    }


    public void y(String... u) {
        System.out.println("test");
    }


    public static String copyFile(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        if (!source.exists()) {
            return null;
        }
        File target = new File(targetPath);
        File parentFile = target.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (target.exists()) {
            target.delete();
        }
        FileOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = new FileOutputStream(targetPath);
            fileInputStream = new FileInputStream(source);
            byte[] size = new byte[1024];
            int read = fileInputStream.read(size);
            while (read > 0) {
                outputStream.write(size, 0, read);
                outputStream.flush();
                read = fileInputStream.read(size);
            }

            return targetPath;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public String sttus(SelfStatus status){

        return status.getStatus();
    }


}