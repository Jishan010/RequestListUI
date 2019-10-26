package com.mobility.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created By JISHAN ANSARI On 10/25/2019
 */

public class Dob {


    @SerializedName("age")
    @Expose
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}