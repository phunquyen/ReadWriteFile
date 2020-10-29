package com.xtel.training.write_read_file.entities;

import org.apache.log4j.Logger;

public class Student {

    public static final Logger logger = Logger.getLogger(Student.class);

    public static String id;
    public static String name;
    public static int gender;
    public static String address;

    public Student() {
    }

    public Student(String id, String name, int gender, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}