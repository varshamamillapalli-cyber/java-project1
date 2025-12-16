package com.klu.apas.model;
public class Marks {
	    private int rollno;
	    private String subject;
	    private int marks;

	    public Marks(int rollno, String subject, int marks) {
	        this.rollno = rollno;
	        this.subject = subject;
	        this.marks = marks;
	    }
		public int getRollno() {
			return rollno;
		}
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}

		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
}
