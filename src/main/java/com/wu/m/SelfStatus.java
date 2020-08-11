package com.wu.m;

public enum SelfStatus {
    node1("PDING"),node2("CLOSE");
    private String status;

    private SelfStatus (String status){
        this.status = status;
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
