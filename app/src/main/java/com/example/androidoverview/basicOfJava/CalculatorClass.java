package com.example.androidoverview.basicOfJava;

import java.util.Scanner;

public class CalculatorClass {
    public static void main(String[] args) {

        char operator;
        double firstNumber, secondNumber, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an getOperator: +, -, *, or /");
        operator = input.next().charAt(0);
        System.out.println("Enter first number");
        firstNumber = input.nextDouble();
        System.out.println("Enter second number");
        secondNumber = input.nextDouble();

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println(firstNumber + " + " + secondNumber + " = " + result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                System.out.println(firstNumber + " - " + secondNumber + " = " + result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                System.out.println(firstNumber + " * " + secondNumber + " = " + result);
                break;
            case '/':
                result = firstNumber / secondNumber;
                System.out.println(firstNumber + " / " + secondNumber + " = " + result);
                break;
            default:
                System.out.println("Invalid Operator!");
                break;
        }
        input.close();
    }
}
