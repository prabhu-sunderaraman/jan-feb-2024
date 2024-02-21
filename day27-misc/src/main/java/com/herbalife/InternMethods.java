package com.herbalife;

public class InternMethods {
    public static void main(String[] args) {
        //Not a very useful method in a real world scenario
        //Stick to one way of creating Strings
        String str1 = "Sample";
        String str5 = "Sample";
        //String str2 = new String("Sample");
        String str2 = str1.intern();
        String str3 = new String("Sample");
        String str4 = str3.intern();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3); //false
        System.out.println(str1 == str4);
        System.out.println(str1 == str5);
    }
}
