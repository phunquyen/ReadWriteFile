package com.xtel.training.write_read_file;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Student {

    static final Logger logger = Logger.getLogger(Student.class);

    private String id;
    private String name;
    private int gender;
    private String address;

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

    public void inputInfoStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        this.id = sc.nextLine();
        System.out.print("Student Name: ");
        this.name = sc.nextLine();
        System.out.print("Student Gender: ");
        this.gender = Integer.parseInt(sc.nextLine());
        System.out.print("Student Address: ");
        this.address = sc.nextLine();
    }

    public void showInfoStudent() {
        System.out.println("Student ID: " + this.id);
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Gender (0-nu, 1-nam): " + this.gender);
        System.out.println("Student Address: " + this.address);
        logger.info(" Student ID: " + this.id + " Student Name: " + this.name + " Student Gender: " + this.gender +
                " Student Adress: " + this.address);
    }
}