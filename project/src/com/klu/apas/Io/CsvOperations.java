package com.klu.apas.Io;
	import java.util.List;
	public interface CsvOperations {
	    List<String> read(String fileName) throws Exception;
	    void write(String fileName, String data) throws Exception;
	}




