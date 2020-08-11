package com.wu.util.po;

public class FunctionConfig {
    private String basicName;
    private String function;

    public FunctionConfig(String basicName, String function) {
        this.basicName = basicName;
        this.function = function;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
