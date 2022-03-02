package com.example.androidoverview.basicOfJava;

enum Days {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
}

public class EnumerationClass {
    Days day;
    public EnumerationClass(Days day) {
        this.day = day;
        getWeekName();
    }

    public void getWeekName() {
        switch (day) {
            case MONDAY:
                System.out.println("Hello today is Monday");
                break;
            case TUESDAY:
                System.out.println("Hello today is Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Hello today is Wednesday");
                break;
            case THURSDAY:
                System.out.println("Hello today is Thursday");
                break;
            case FRIDAY:
                System.out.println("Hello today is Friday");
                break;
            case SATURDAY:
                System.out.println("Hello today is Saturday");
                break;
            case SUNDAY:
                System.out.println("Hello today is Sunday");
                break;
            default:
                System.out.println("Please enter a valid day");
        }
    }

    public static void main (String[] args) {
        EnumerationClass getdays;
        for (Days day : Days.values()) {
            getdays = new EnumerationClass(day);
        }
    }
}
