package com.klu.apas.util;
	import java.util.Collections;
	import java.util.List;
	public class Mathutil {
	    public static double calculateMean(List<Integer> nums) {
	        if (nums == null || nums.isEmpty()) return 0.0;
	        double sum = 0;
	        for (int n : nums) sum += n;
	        return sum / nums.size();
	    }
	    public static double calculateMedian(List<Integer> nums) {
	        if (nums == null || nums.isEmpty()) return 0.0;
	        Collections.sort(nums);
	        int n = nums.size();
	        if (n % 2 == 1) {
	            return nums.get(n / 2);
	        } else {
	            return (nums.get(n / 2 - 1) + nums.get(n / 2)) / 2.0;
	        }
	    }
	    public static double calculateStdDev(List<Integer> nums) {
	        if (nums == null || nums.isEmpty()) return 0.0;
	        double mean = calculateMean(nums);
	        double sumSq = 0;
	        for (int n : nums) {
	            double diff = n - mean;
	            sumSq += diff * diff;
	        }
	        return Math.sqrt(sumSq / nums.size());
	    }
	}
