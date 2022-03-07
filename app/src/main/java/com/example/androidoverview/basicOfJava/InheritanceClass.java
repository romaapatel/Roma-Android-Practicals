package com.example.androidoverview.basicOfJava;

class Mobile {
        void getOSUsed() {
        System.out.println("Os Details");
        }
}

class Iphone extends  Mobile {
    @Override
    void getOSUsed() {
        super.getOSUsed();
        System.out.println(" Os Used IOS in Iphone");
    }
}

class Android extends  Mobile {
    @Override
    void getOSUsed() {
        super.getOSUsed();
        System.out.println(" Os Used Android in ");
    }
}

public class InheritanceClass {
    public static void main (String[] args) {
        Android android = new Android();
        Iphone iphone = new Iphone();
        android.getOSUsed();
        iphone.getOSUsed();
    }
}
