package com.klu.apas.model;
	import java.util.List;
	import com.klu.apas.util.Mathutil;
	public class Subjectstats {
	    private double mean;
	    private double median;
	    private double stdDev;
	    private List<Integer> marks;

	    public Subjectstats(List<Integer> marks) {
	        this.marks = marks;
	        this.mean = Mathutil.calculateMean(marks);
	        this.median = Mathutil.calculateMedian(marks);
	        this.stdDev = Mathutil.calculateStdDev(marks);
	    }

		public double getMean() {
			return mean;
		}
		public void setMean(double mean) {
			this.mean = mean;
		}
		public double getMedian() {
			return median;
		}
		public void setMedian(double median) {
			this.median = median;
		}
		public double getStdDev() {
			return stdDev;
		}
		public void setStdDev(double stdDev) {
			this.stdDev = stdDev;
		}
		public List<Integer> getMarks() {
			return marks;
		}
		public void setMarks(List<Integer> marks) {
			this.marks = marks;
		}

	}


