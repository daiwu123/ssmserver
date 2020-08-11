package com.wu.po;

import java.io.Serializable;

public class Money1 implements Serializable {
    private int id;
    private int number;
    private int pop_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPop_id() {
        return pop_id;
    }

    public void setPop_id(int pop_id) {
        this.pop_id = pop_id;
    }
}
