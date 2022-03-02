package com.example.androidoverview.basicOfJava;

public class ExceptionHandlingClass {
    public static void main(String[] args) {

        try {
            int firstValue = 20;
            int div, secondValue = 0;
            div = firstValue/secondValue;
            System.out.println("Output:" + div);
        }
        catch (ArithmeticException exception) {
            System.out.println("We cannot divide any number by zero.");
        }

        try {
            int[] arrayList = new int [10];
            arrayList[11] = 10;
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Array size out of bound");
        }

        try {
            int num = Integer.parseInt("Hello Roma");
            System.out.println(num);
        }
        catch (NumberFormatException exception) {
            System.out.println("Number Format Exception has occurred");
        }
    }
}
