	package com.klu.apas.report;

	import com.klu.apas.model.Student;
	import java.util.*;

	public class CsvReportWriter implements ReportWriter {

	    @Override
	    public void writeReport(List<Student> students, String fileName) throws Exception {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Roll,Name,Class,Total,Grade\n");
	        for (Student s : students) {
	            sb.append(String.format("%d,%s,%s,%d,%s\n",
	                    s.getRoll(), s.getName(), s.getClassName(),
	                    s.getTotalMarks(), s.getGrade() == null ? "" : s.getGrade()
	            ));
	        }
	        // use FileUtil directly to write
	        new com.klu.apas.Io.FileUtil().write(fileName, sb.toString());
	    }
	}


