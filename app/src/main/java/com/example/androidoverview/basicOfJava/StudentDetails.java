package com.example.androidoverview.basicOfJava;
import java.util.Scanner;

interface Details {
    public void getName();
    public void getRollNo();
}

class Student implements Details {
    Scanner scanner = new Scanner(System.in);
    @Override

    public void getName() {
        String name;
        System.out.println("Name :");
        name = scanner.nextLine();
    }

    public void getRollNo() {
        int rollNo;
        System.out.println( " Roll no ");
        rollNo = scanner.nextInt();
    }
}

public class StudentDetails {
    public static  void main(String args[]) {
        int initalValue;
        for (initalValue = 1; initalValue <= 5; initalValue++) {
            Student student = new Student();
            student.getName();
            student.getRollNo();
        }
    }
}
