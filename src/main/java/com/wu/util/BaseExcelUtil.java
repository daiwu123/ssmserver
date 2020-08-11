package com.wu.util;

import com.wu.util.canno.ExcelMark;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaseExcelUtil {
    protected final String[]  EXCEL_XLSX  = {"xlsx","csv"};
    protected final String[]  EXCEL_XLS  = {"xls"};
    protected final String[]  FIELD_TYPE_NAME  = {"java.lang.String","java.util.Date","java.util.Boolean"};
    protected final List<String> EXCEL_XLSX_LIST;
    protected final List<String> EXCEL_XLS_LIST;
    protected final List<String> FIELD_TYPE_LIST;
    protected final SimpleDateFormat SIMPLE_DATE_FORMATER = new SimpleDateFormat("yyyy-MM-dd");
    protected final DecimalFormat NUMBER_FORMATER = new DecimalFormat("#");

    public BaseExcelUtil(){
        EXCEL_XLSX_LIST = Arrays.asList(EXCEL_XLSX);
        EXCEL_XLS_LIST = Arrays.asList(EXCEL_XLS);
        FIELD_TYPE_LIST = Arrays.asList(FIELD_TYPE_NAME);
    }

    /**
     * 描述:
     * @param c(Class<T>对象),sheetIndex(sheet索引),workbook(文件work对象)
     * return  List<T>
     * Author Dai Wu
     * Date 2019/12/25 9:49
     *
     * **/
    protected   <T> List<T> generateData(Class<T> c, int sheetIndex, Workbook workbook) throws IllegalAccessException, InstantiationException {
        List<T> result = new ArrayList<>();
        Map<Integer,Field> colMappingObjctFieldMap = null;
        //Object
        Field[] declaredFields = c.getDeclaredFields();
        //Excel
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int firstRowNumber = sheet.getFirstRowNum();
        int lastRowNumber = sheet.getLastRowNum();
        //总行数
        int rowNumberCount = lastRowNumber+1;
        //总行数>0说明有数据 Excel文件时有效的
        //渲染Excel标题对应对象中的属性  colMappingObjctFieldMap ,固定获取Excel第一行表头
        if(rowNumberCount>0){
            colMappingObjctFieldMap =  titleColMappingObjField(declaredFields, sheet, firstRowNumber);
        }else{
            return result;
        }
        for (int i = firstRowNumber+1; i < rowNumberCount; i++) {
            Row row = sheet.getRow(i);
            T targetObj = c.newInstance();
            int firstCellIndex = row.getFirstCellNum();
            int lastCellIndex = row.getLastCellNum();
            for (int j = firstCellIndex; j < lastCellIndex; j++) {
                Field field = colMappingObjctFieldMap.get(j);
                Cell cell = row.getCell(j);
                //根据cell获取不同类型的值
                CellTypeGetData(cell,field,targetObj);

            }
            result.add(targetObj);
        }
        return result;
    }





    /**
     * 描述:
     * @param fileName(文件名称)  in(导入的文件流)
     * return  org.apache.poi.hssf.usermodel.Workbook
     * Author Dai Wu
     * Date 2019/12/24 15:12
     *
     * **/
    protected Workbook getWorkbook(String fileName, InputStream in) throws IOException {
        if(fileName!=null && !"".equals(fileName)){
            int suffixIndex =  fileName.lastIndexOf(".");
            if(suffixIndex!=-1){
                String suffixName = fileName.substring(suffixIndex+1,fileName.length());
                if(this.EXCEL_XLSX_LIST.contains(suffixName)){
                    return new XSSFWorkbook(in);
                }else if(this.EXCEL_XLS_LIST.contains(suffixName)){
                    return new HSSFWorkbook(in);
                }else{
                    return null;
                }
            }
        }
        return null;
    }
    /**
     * 描述: 生成对应的excel对象
     * @param fileName
     * return  Workbook
     * Author Dai Wu
     * Date 2020/1/8 9:32
     *
     * **/
    protected Workbook getWorkbook(String fileName) throws IOException {
        if(fileName!=null && !"".equals(fileName)){
            int suffixIndex =  fileName.lastIndexOf(".");
            if(suffixIndex!=-1){
                String suffixName = fileName.substring(suffixIndex+1,fileName.length());
                if(this.EXCEL_XLSX_LIST.contains(suffixName)){
                    return new XSSFWorkbook();
                }else if(this.EXCEL_XLS_LIST.contains(suffixName)){
                    return new HSSFWorkbook();
                }else{
                    return null;
                }
            }
        }
        return null;
    }




    /**
     * 描述: Excel列名 Mapping 对象 Field
     * @param  declaredFields,sheet,firstRowNumber
     * return  Map<Integer, Field>
     * Author Dai Wu
     * Date 2019/12/25 9:43
     *
     * **/
    private Map<Integer, Field> titleColMappingObjField(Field[] declaredFields, Sheet sheet, int firstRowNumber) {
        Map<Integer, Field> colMappingObjctFieldMap =  new HashMap<>();
        //获取标题行
        Row titleRow = sheet.getRow(firstRowNumber);
        int titleFristColNumber = titleRow.getFirstCellNum();
        int titleLastColNumber = titleRow.getLastCellNum();
        //忽略取Excel第一列的数据
        // int ignoreFirstCol = titleFristColNumber+1;
        for (int i = titleFristColNumber; i < titleLastColNumber; i++) {
            Cell titleRowCell = titleRow.getCell(i);
            //标题都是String类型
            String cellTitle = titleRowCell.getStringCellValue();
            for (int j = 0; j < declaredFields.length; j++) {
                Field curField = declaredFields[j];
                curField.setAccessible(true);
                if(curField.isAnnotationPresent(ExcelMark.class)){
                    ExcelMark declaredAnnotation = curField.getDeclaredAnnotation(ExcelMark.class);
                    String markColName = declaredAnnotation.excelColName();
                    //注解标记的属性和Excel列名一致
                    if(markColName.equals(cellTitle)){
                        colMappingObjctFieldMap.put(i,curField);
                    }
                }
            }
        }
        return colMappingObjctFieldMap;
    }


    /**
     * 描述:
     * @param cell(Cell对象)
     * return  String 当前cell对象中的值
     * Author Dai Wu
     * Date 2019/12/25 9:55
     *
     * **/
    private <T> T  CellTypeGetData(Cell cell,Field field,T targetObj) throws IllegalAccessException {
        //if(field.getTypeName().getClass().isInstance())
        Object cellValue = null;
        if(cell!=null && field!=null){
            Class<?> fieldTypeClazz = field.getType();
            int originCode = cell.getCellType().ordinal();
            if(originCode == CellType.STRING.ordinal()){
                String value = cell.getStringCellValue();
                if(fieldTypeClazz.isInstance(value)){
                    cellValue = value;
                }else{
                    System.out.println("Field对应的列类型不对..");
                }
            }else if(originCode == CellType.BOOLEAN.ordinal()){
                Boolean value = cell.getBooleanCellValue();
                if(fieldTypeClazz.isInstance(value)){
                    cellValue = value;
                }else if(fieldTypeClazz.isInstance(value+"")){
                    cellValue = value+"";
                }else{
                    System.out.println("Field对应的列类型不对..");
                }
            }else if(originCode ==CellType.NUMERIC.ordinal()){
                if(DateUtil.isCellDateFormatted(cell)){
                    Date value = cell.getDateCellValue();
                    String stringValue = SIMPLE_DATE_FORMATER.format(value);
                    Timestamp valueTimestamp = new Timestamp(value.getTime());
                    if(fieldTypeClazz.isInstance(value)){
                        cellValue = value;
                    }else if(fieldTypeClazz.isInstance(stringValue)){
                        cellValue = stringValue;
                    }else if(fieldTypeClazz.isInstance(valueTimestamp)){
                        cellValue = valueTimestamp;
                    }else{
                        System.out.println("Field对应的列类型不对..");
                    }
                    // cellValue =  SIMPLE_DATE_FORMATER.format();
                }else{
                    double value = cell.getNumericCellValue();
                    String stringValue = NUMBER_FORMATER.format(value);
                    if(fieldTypeClazz.isInstance(value)){
                        cellValue = value;
                    }else if(fieldTypeClazz.isInstance(stringValue)){
                        cellValue = stringValue;
                    }else{
                        System.out.println("Field对应的列类型不对..");
                    }
                    //cellValue = NUMBER_FORMATER.format(cell.getNumericCellValue());
                }
                //cellValue = cell.getNumericCellValue()+"";
            }else if(originCode == CellType.FORMULA.ordinal()){
                String value =   cell.getCellFormula();
                if(fieldTypeClazz.isInstance(value)){
                    cellValue = value;
                }else{
                    System.out.println("Field对应的列类型不对..");
                }
            }else {
                cellValue = null;
            }
            //防止Excel中有多余列，但是在实体类中没有做注解标记
            field.set(targetObj,cellValue);
        }
        return null;
    }
}
