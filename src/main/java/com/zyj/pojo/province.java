package com.zyj.pojo;

import java.io.Serializable;

public class province implements Serializable {
    private int pid;
    private String pname;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
