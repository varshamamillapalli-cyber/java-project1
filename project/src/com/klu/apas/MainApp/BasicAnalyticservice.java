package com.klu.apas.MainApp;

import com.klu.apas.model.Student;
import com.klu.apas.service.Analyticservice;
import com.klu.apas.strategy.GradingPolicy;
import java.util.*;

public class BasicAnalyticservice implements Analyticservice {

    private GradingPolicy gradingPolicy;

    public BasicAnalyticservice(GradingPolicy gradingPolicy) {
        this.gradingPolicy = gradingPolicy;
    }

    public int calculateTotal(Student s) {
        int total = 0;
        for (int m : s.getSubjectMarks().values()) {
        System.out.println("M value :"+m);
        	total += m;
        }
        
        s.setTotalMarks(total);
        return total;
    }

    public String assignGrade(int total) {
        return gradingPolicy.computeGrade(total);
    }

    @Override
    public double calculateMean(List<Integer> marks) {
        return marks.stream().mapToInt(i -> i).average().orElse(0);
    }

    @Override
    public double calculateMedian(List<Integer> marks) {
        if (marks.isEmpty()) return 0;
        Collections.sort(marks);
        int n = marks.size();
        return (n % 2 == 1)
                ? marks.get(n / 2)
                : (marks.get(n / 2 - 1) + marks.get(n / 2)) / 2.0;
    }

    @Override
    public double calculateStdDev(List<Integer> marks) {
        double mean = calculateMean(marks);
        double sum = 0;
        for (int m : marks) sum += Math.pow(m - mean, 2);
        return marks.isEmpty() ? 0 : Math.sqrt(sum / marks.size());
    }
}

