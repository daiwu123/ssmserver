package com.wu.util.canno;

public enum SelfEnum {
    ERROR_CODE_0001("0001", "Semi-auto_disposition code\"99\"", "Change", "SSD Engineer"),
    ERROR_CODE_0002("0002", "Semi-auto_disposition code\"99\"", "Change", "SSD Engineer"),
    /*Disposition 合法值01, 02, 03, 06, 07, 09, 19, 22, 24, 99,空, 否则错误信息如下*/
    ERROR_CODE_0003("0003","ErrorCode-Disposition code can not be found.","Change","SSD Engineer"),
    ERROR_CODE_0004("0004","Change type is not in scope.",null,null),
    ERROR_CODE_0005("0005","ErrorCode-Disposition code un-defined(FRU disposition is not 06/19/22/99).",null,null),
    ERROR_CODE_0006("0006","The fru did not find a module.",null,null),
    ERROR_CODE_0007("0007","Qty of child part %s (Lenovo child part no) is empty.",null,null);

    private String errorCode;
    private String message;
    private String group;
    private String changeType;
    private SelfEnum(String errorCode, String message, String changeType, String group) {
        this.errorCode = errorCode;
        this.message = message;
        this.changeType = changeType;
        this.group = group;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



    public String setMessage(String ...formart) {
        String message = this.message;
        if(formart!=null && formart.length>0){
            String[] mes = this.message.split("%s");
            for (int j = 0; j < formart.length; j++) {
                message = message.replaceFirst("%s", formart[j]);
            }
        }
        return message;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }
}
