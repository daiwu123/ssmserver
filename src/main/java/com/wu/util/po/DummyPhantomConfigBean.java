package com.wu.util.po;

import com.wu.util.canno.ExcelMark;

import java.io.Serializable;

/**
 * 描述: DummyPhantomConfigBean
 * @param null
 * return
 * Author Dai Wu
 * Date 2019/12/28 16:25
 *
 * **/
public class DummyPhantomConfigBean extends BasicConfigBean implements Serializable{
    @ExcelMark(excelColName = "Basic Name")
    private String basicName;
    @ExcelMark(excelColName = "Type Name")
    private String typeName;
    @ExcelMark(excelColName = "Description")
    private String description;

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
