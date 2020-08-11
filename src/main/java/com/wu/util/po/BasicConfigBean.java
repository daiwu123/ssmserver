package com.wu.util.po;

import com.wu.util.canno.ExcelMark;


import java.io.Serializable;

public class BasicConfigBean implements Serializable {
    @ExcelMark(excelColName = "Str1")
    String str1;
    @ExcelMark(excelColName = "Str2")
    String str2;
    @ExcelMark(excelColName = "Str3")
    String str3;
    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

}
