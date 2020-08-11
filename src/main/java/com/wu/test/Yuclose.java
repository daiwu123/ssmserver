package com.wu.test;

public class Yuclose {
    private String parent;
    private String child;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public Yuclose(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
    public Yuclose(){}
}
