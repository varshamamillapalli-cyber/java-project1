package com.klu.apas.MainApp;
import com.klu.apas.service.*;

	import com.klu.apas.model.*;
	import com.klu.apas.Io.*;
	import com.klu.apas.service.*;
	import com.klu.apas.strategy.*;
	import com.klu.apas.report.*;
	import com.klu.apas.exception.*;
	import com.klu.apas.util.*;

	import java.util.*;
	import java.util.stream.Collectors;

	public class MainApp1 {

	    private static List<Student> students = new ArrayList<>();
	    private static List<Mark> marks = new ArrayList<>();
	    private static Analyticservice analytics = new BasicAnalyticservice(new SimpleGradingPolicy());

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        StudentCsvReader studentReader = new StudentCsvReader();
	        MarksCsvReader marksReader = new MarksCsvReader();

	        while (true) {
	            System.out.println("========= ACADEMIC PERFORMANCE ANALYTICS SYSTEM =========");
	            System.out.println("1. Load Students CSV");
	            System.out.println("2. Load Marks CSV");
	            System.out.println("3. Perform Analytics (Totals, Mean, Median, StdDev)");
	            System.out.println("4. Generate Rank List");
	            System.out.println("5. Generate Grade Summary");
	            System.out.println("6. Export Report to CSV");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = Integer.parseInt(sc.nextLine());

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Students CSV file path: ");
	                        String sfile = sc.nextLine();
	                        students = (List<Student>) (List<?>) studentReader.readCsv(sfile);
	                        System.out.println("Loaded " + students.size() + " students.");
	                        break;

	                    case 2:
	                        System.out.print("Marks CSV file path: ");
	                        String mfile = sc.nextLine();
	                        marks = (List<Mark>) (List<?>) marksReader.readCsv(mfile);
	                        System.out.println("Loaded " + marks.size() + " marks.");
	                        // attach marks to students
	                        Map<Integer, Student> map = students.stream()
	                                .collect(Collectors.toMap(Student::getRoll, s -> s));
	                        for (Mark mk : marks) {
	                            Student st = map.get(mk.getRollno());
	                            if (st != null) st.addMark(mk.getSubject(), mk.getMarks());
	                        }
	                        break;

	                    case 3:
	                        performAnalytics();
	                        break;

	                    case 4:
	                        generateRankList();
	                        break;

	                    case 5:
	                        generateGradeSummary();
	                        break;

	                    case 6:
	                        System.out.print("Output CSV filename (eg grades.csv): ");
	                        String out = sc.nextLine();
	                        ReportWriter writer = ReportWriterFactory.getWriter("csv");
	                        writer.writeReport(students, out);
	                        System.out.println("Report exported to " + out);
	                        break;

	                    case 7:
	                        System.out.println("Bye!");
	                        sc.close();
	                        return;

	                    default:
	                        System.out.println("Invalid choice");
	                }
	            } catch (Exception ex) {
	                System.out.println("Error: " + ex.getMessage());
	            }

	            System.out.println();
	        }
	    }

	    private static void performAnalytics() {
	        System.out.println("Running analytics...");
	        for (Student s : students) {
	            int total = Analyticservice.calculateTotal(s);
	            s.setGrade(Analyticservice.assignGrade(total));
	        }


	        Map<String, List<Integer>> subjMap = new LinkedHashMap<>();
	        for (Student s : students) {
	            for (Map.Entry<String,Integer> e : s.getSubjectMarks().entrySet()) {
	                subjMap.computeIfAbsent(e.getKey(), k -> new ArrayList<>()).add(e.getValue());
	            }
	        }

	        for (Map.Entry<String,List<Integer>> e : subjMap.entrySet()) {
	            String subj = e.getKey();
	            List<Integer> values = e.getValue();
	            System.out.printf("Subject: %s Mean: %.2f Median: %.2f StdDev: %.2f%n",
	                    subj,
	                    Mathutil.calculateMean(values),
	                    Mathutil.calculateMedian(values),
	                    Mathutil.calculateStdDev(values));
	        }
	        System.out.println("Analytics complete.");
	    }

	    private static void generateRankList() {
	        System.out.println("Rank List:");
	        List<Student> ranked = new ArrayList<>(students);
	        ranked.sort(Comparator.comparingInt(Student::getTotalMarks).reversed());
	        int rank = 1;
	        for (Student s : ranked) {
	            System.out.printf("%d. Roll:%d Name:%s Total:%d Grade:%s%n",
	                    rank++, s.getRoll(), s.getName(), s.getTotalMarks(), s.getGrade());
	        }
	    }

	    private static void generateGradeSummary() {
	        Map<String, Long> summary = students.stream()
	                .collect(Collectors.groupingBy(s -> s.getGrade() == null ? "UNASSIGNED" : s.getGrade(),
	                        Collectors.counting()));
	        System.out.println("Grade Summary:");
	        summary.forEach((g, cnt) -> System.out.println(g + " -> " + cnt));
	    }
	}

