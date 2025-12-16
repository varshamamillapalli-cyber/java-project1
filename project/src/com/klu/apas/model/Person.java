package com.klu.apas.model;
public class Person {
	    public int rollno;
	    public String name;

	    public Person() {
	    }
	    public Person(int rollno, String name) {
	        this.rollno = rollno;
	        this.name = name;
	    }
	    public int getRoll() {
	        return rollno;
	    }
	    public void setRoll(int rollno) {
	        this.rollno = rollno;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	}
