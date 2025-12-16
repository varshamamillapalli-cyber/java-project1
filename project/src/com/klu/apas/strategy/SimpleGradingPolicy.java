package com.klu.apas.strategy;
	public class SimpleGradingPolicy implements GradingPolicy {
	    @Override
	    public String computeGrade(int total) {
	        double percent = (total / 300.0) * 100;
	        if (percent >= 75) return "A";
	        if (percent >= 60) return "B";
	        if (percent >= 50) return "C";
	        if (percent >= 35) return "D";
	        return "F";
	    }
	}

