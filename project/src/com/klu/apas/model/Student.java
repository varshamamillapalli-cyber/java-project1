package com.klu.apas.model;
	import java.util.HashMap;
	import java.util.Map;
	public class Student extends Person {
	    private String className;
	    private Map<String, Integer> subjectMarks;
	    private int totalMarks;
	    private String grade;

	    public Student() {
	        this.subjectMarks = new HashMap<>();
	    }
	    public Student(int rollno, String name, String className) {
	        super(rollno,name);
	        this.className = className;
	        this.subjectMarks = new HashMap<>();
	    }
	    public void addMark(String subject, int marks) {
	        subjectMarks.put(subject, marks);
	    }
	    public Map<String, Integer> getSubjectMarks() {
	        return subjectMarks;
	    }
	    public int getTotalMarks() {
	        return totalMarks;
	    }
	    public void setTotalMarks(int total) {
	        this.totalMarks = total;
	    }
	    public void setGrade(String grade) {
	        this.grade = grade;
	    }
	    public String getGrade() {
	        return grade;
	    }
	    public String getClassName() {
	        return className;
	    }
	    public void setClassName(String className) {
	        this.className = className;
	    }
	    public void displayStudentInfo() {
	        System.out.println("Roll: " + rollno +
	                ", Name: " + name+
	                ", Class: " + className +
	                ", Total: " + totalMarks +
	                ", Grade: " + grade);
	    }
	}


