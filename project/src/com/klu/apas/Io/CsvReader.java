package com.klu.apas.Io;
	import java.util.List;

	public abstract class CsvReader {
	    protected CsvOperations ops = new FileUtil();

	    public List<?> readCsv(String fileName) throws Exception {
	        List<String> lines = ops.read(fileName);
	        return parse(lines);
	    }

	    protected abstract List<?> parse(List<String> lines) throws Exception;
	}



