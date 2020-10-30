package com.xtel.training.write_read_file.management;

import java.util.Scanner;
import com.xtel.training.write_read_file.entities.Student;
public class StudentManager extends Student {

    public void inputInfoStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        Student.id = Integer.parseInt(sc.nextLine());
        System.out.print("Student Name: ");
        Student.name = sc.nextLine();
        System.out.print("Student Gender: ");
        Student.gender = Integer.parseInt(sc.nextLine());
        System.out.print("Student Address: ");
        Student.address = sc.nextLine();
    }

    public void showInfoStudent() {
        System.out.println("Student ID: " + Student.id);
        System.out.println("Student Name: " + Student.name);
        System.out.println("Student Gender (0-nu, 1-nam): " + Student.gender);
        System.out.println("Student Address: " + Student.address);
        Student.logger.info(" Student ID: " + Student.id + " Student Name: " + Student.name + " Student Gender: " + Student.gender +
                " Student Adress: " + Student.address);
    }
}
