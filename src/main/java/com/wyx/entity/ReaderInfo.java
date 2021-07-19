package com.wyx.entity;

public class ReaderInfo {
    private String reName;
    private int stuID;
    private String reSex;
    private String Email;

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getReSex() {
        return reSex;
    }

    public void setReSex(String reSex) {
        this.reSex = reSex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public ReaderInfo(String reName, String reSex, String email) {
        this.reName = reName;
        this.reSex = reSex;
        Email = email;
    }

    public ReaderInfo() {
    }

    public ReaderInfo(String reName, int stuID, String reSex, String email) {
        this.reName = reName;
        this.stuID = stuID;
        this.reSex = reSex;
        Email = email;
    }

    @Override
    public String toString() {
        return "readerInfo{" +
                "reName='" + reName + '\'' +
                ", stuID=" + stuID +
                ", reSex='" + reSex + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
