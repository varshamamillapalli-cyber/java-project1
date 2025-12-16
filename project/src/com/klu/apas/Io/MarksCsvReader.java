package com.klu.apas.Io;

import com.klu.apas.model.Mark;
import com.klu.apas.exception.FileFormatException;
import java.util.*;

public class MarksCsvReader extends CsvReader {

    @Override
    protected List<Mark> parse(List<String> lines) throws Exception {
        List<Mark> marks = new ArrayList<>();
        boolean headerSkipped = false;
        for (String line : lines) {
            if (!headerSkipped) { headerSkipped = true; continue; } // skip header
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length < 3) throw new FileFormatException("Invalid marks.csv format");
            int roll = Integer.parseInt(parts[0].trim());
            String subject = parts[1].trim();
            int m = Integer.parseInt(parts[2].trim());

            // create Mark with roll, subject and marks
            marks.add(new Mark(roll, subject, m));
        }
        return marks;
    }
}
