	package com.klu.apas.report;

	public class ReportWriterFactory {
	    public static ReportWriter getWriter(String type) {
	        if (type.equalsIgnoreCase("csv")) return new CsvReportWriter();
	        return null;
	    }
	}


