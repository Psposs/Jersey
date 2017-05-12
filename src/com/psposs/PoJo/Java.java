package com.psposs.PoJo;

import java.io.Serializable;

/**
 * Created by chetuan on 2017/5/10.
 */
public class Java implements Serializable{

    private  String name;
    private String sex;
    private  String age;
    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

}
