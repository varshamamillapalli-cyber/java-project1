package com.klu.apas.Io;
	import java.nio.file.*;
	import java.util.*;
	import java.io.IOException;

	public class FileUtil implements CsvOperations {

	    @Override
	    public List<String> read(String fileName) throws Exception {
	        Path p = Paths.get(fileName);
	        if (!Files.exists(p)) throw new IOException("File not found: " + fileName);
	        return Files.readAllLines(p);
	    }

	    @Override
	    public void write(String fileName, String data) throws Exception {
	        Path p = Paths.get(fileName);
	        Files.write(p, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	    }
	}


