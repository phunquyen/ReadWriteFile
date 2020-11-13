package com.xtel.training.write_read_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.xtel.training.write_read_file.entities.Student;
import com.xtel.training.write_read_file.management.StudentManager;
import org.apache.log4j.Logger;

public class MainApplication {
    static final Logger logger = Logger.getLogger(MainApplication.class);
    private static String filePath = "log4j.properties";
    ArrayList<Student> listStudent = new ArrayList<>();

    public void inputNumberStudent() {
        logger.info("Start inputInfoStudent !");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudent = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfStudent; i++) {
            System.out.println("No. " + (i + 1));
            StudentManager student = new StudentManager();
            student.inputInfoStudent();
            listStudent.add(student);
        }
        logger.info("End inputInfoStudent !");
    }

    public void showInfoStudent() {
        logger.info("Start showInfoStudent !");
        System.out.print("List of student");
        for (int i = 0; i < listStudent.size(); i++) {
            StudentManager student = (StudentManager) listStudent.get(i);
            student.showInfoStudent();
        }
        logger.info("End showInfoStudent !");
    }

    public void writeFile() {
        File file = new File(filePath);
        if (file.exists()) {
            logger.info("Create file successful.Locate file: !" + file.getPath());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(listStudent);
                logger.info(listStudent);
                objectOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Error while write file !!!. Message: " + e.getMessage());
            }
        } else {
            logger.error("Create file failure!");
        }
    }

    public void readFile() {
        File file = new File(filePath);
        if (file.exists()) {
            logger.info("Locate file: " + file.getPath());
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                List<Student> listStudent = (List<Student>) objectInputStream.readObject();
                if (listStudent == null) {
                    logger.warn("File is empty!");
                } else {
                    logger.info(listStudent);
                    for (Student student : listStudent) {
                        System.out.println("Student ID: " + student.getId());
                        System.out.println("Student Name: " + student.getName());
                        System.out.println("Student Gender (0-female, 1-male): " + student.getGender());
                        System.out.println("Student Address: " + student.getAddress());
                    }
                }
                fileInputStream.close();
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Error while read file. Message: " + e.getMessage());
            }
        } else {
            logger.error("File not exists");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainApplication mainApplication = new MainApplication();
        do {
            System.out.println("1.Enter information of student.");
            System.out.println("2.Show information of student");
            System.out.println("3.Write file.");
            System.out.println("4.Read file.");
            System.out.println("5.Exit!");
            System.out.println("");
            System.out.print("Option:");
            int Option = Integer.parseInt(sc.nextLine());
            switch (Option) {
                case 1:
                    logger.warn("Insert data ! ");
                    mainApplication.inputNumberStudent();
                    break;
                case 2:
                    logger.warn("Get data !");
                    mainApplication.showInfoStudent();
                    break;
                case 3:
                    logger.warn("Writing file !");
                    mainApplication.writeFile();
                    break;
                case 4:
                    logger.warn("Reading file !");
                    mainApplication.readFile();
                    break;

                default:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
