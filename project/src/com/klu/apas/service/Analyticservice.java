package com.klu.apas.service;

import java.util.List;
import com.klu.apas.model.Student;

public interface Analyticservice {

    static int calculateTotal(Student s) {
		// TODO Auto-generated method stub
    	
    	
		return 0;
	}

    double calculateMean(List<Integer> marks);

    double calculateMedian(List<Integer> marks);

    double calculateStdDev(List<Integer> marks);

    static String assignGrade(int total) {
		// TODO Auto-generated method stub
		return null;
	}
}
