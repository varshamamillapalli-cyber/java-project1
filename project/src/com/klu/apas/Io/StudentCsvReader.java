package com.klu.apas.Io;

	import com.klu.apas.model.Student;
	import com.klu.apas.exception.FileFormatException;
	import java.util.*;

	public class StudentCsvReader extends CsvReader {

	    @Override
	    protected List<Student> parse(List<String> lines) throws Exception {
	        List<Student> students = new ArrayList<>();
	        boolean headerSkipped = false;
	        for (String line : lines) {
	            if (!headerSkipped) { headerSkipped = true; continue; } // skip header
	            if (line.trim().isEmpty()) continue;
	            String[] parts = line.split(",");
	            if (parts.length < 3) throw new FileFormatException("Invalid students.csv format");
	            int roll = Integer.parseInt(parts[0].trim());
	            String name = parts[1].trim();
	            String cls = parts[2].trim();
	            students.add(new Student(roll, name, cls));
	        }
	        return students;
	    }
	}

