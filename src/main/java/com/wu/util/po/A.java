package com.wu.util.po;

import com.wu.util.canno.ExcelMark;

import java.io.Serializable;

public class A implements Serializable {
    @ExcelMark(excelColName = "comment")
    private String comment;
    @ExcelMark(excelColName = "name")
    private String name;
    @ExcelMark(excelColName = "LastModified")
    private String lastModified;

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
