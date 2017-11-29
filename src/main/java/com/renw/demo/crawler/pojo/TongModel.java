package com.renw.demo.crawler.pojo;

/**
 * Created by dell on 2017/11/11.
 */
public class TongModel {
    String fullName;
    String shortName;
    String time;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TongModel{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
