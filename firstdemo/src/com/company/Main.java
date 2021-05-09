package com.company;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello World");
	    IMedia b = new Book(0,"Java",10);
	    System.out.println(b.getNetPrice());
		IMedia cd = new Cd(1,"Java 13",20);
		System.out.println(cd.getNetPrice());
		cd.setPrice(cd.getPrice() + 1);
		System.out.println(cd.getNetPrice());
		IMedia b2 = new Book(0,"Java",10);
		System.out.println(b);
		System.out.println(b2);
		System.out.println(b == b2);
    }
}
