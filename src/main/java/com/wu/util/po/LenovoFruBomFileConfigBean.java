package com.wu.util.po;

import com.wu.util.canno.ExcelMark;

import java.sql.Timestamp;
import java.util.Date;

public class LenovoFruBomFileConfigBean{

    @ExcelMark(excelColName = "Change Type")
    private String changeType;
    @ExcelMark(excelColName = "Lenovo EC/Doc Number")
    private String ecDocNo;
    @ExcelMark(excelColName = "Lenovo EC/Doc Name")
    private String ecDocName;
    @ExcelMark(excelColName = "Created")
    private Timestamp proceedTime;
    @ExcelMark(excelColName = "ignore")
    private Boolean ignoreComponent;

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getEcDocNo() {
        return ecDocNo;
    }

    public void setEcDocNo(String ecDocNo) {
        this.ecDocNo = ecDocNo;
    }

    public String getEcDocName() {
        return ecDocName;
    }

    public void setEcDocName(String ecDocName) {
        this.ecDocName = ecDocName;
    }

    public Timestamp getProceedTime() {
        return proceedTime;
    }

    public void setProceedTime(Timestamp proceedTime) {
        this.proceedTime = proceedTime;
    }

    public Boolean getIgnoreComponent() {
        return ignoreComponent;
    }

    public void setIgnoreComponent(Boolean ignoreComponent) {
        this.ignoreComponent = ignoreComponent;
    }

}
