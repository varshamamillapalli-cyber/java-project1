	package com.klu.apas.report;

	import com.klu.apas.model.Student;
	import java.util.List;

	public interface ReportWriter {
	    void writeReport(List<Student> students, String fileName) throws Exception;
	}


