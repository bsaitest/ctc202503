package com.ctc.demo.common;

import java.io.*;
import java.util.*;

public class LogAnalyzer {

    public static void main(String[] args) throws IOException {
        String logFilePath = "C:\\ctc\\ai\\demo\\src\\main\\java\\com\\ctc\\demo\\business\\TestMain.java";
        analyzeLogs(logFilePath);
    }

    public static void analyzeLogs(String logFilePath) throws IOException {
        List<String> logLines = Files.readAllLines(Paths.get(logFilePath));
        Set<String> expectedLogs = new HashSet<>();
        Set<String> actualLogs = new HashSet<>();

        for (String line : logLines) {
            if (line.startsWith("Entering method") || line.startsWith("Exiting method") ||
                line.startsWith("Entering if statement") || line.startsWith("Entering loop") ||
                line.startsWith("Entering switch statement") || line.startsWith("Entering case")) {
                actualLogs.add(line);
            }
        }

        // Assuming you have a way to generate the expected logs
        generateExpectedLogs(expectedLogs);

        for (String expectedLog : expectedLogs) {
            if (!actualLogs.contains(expectedLog)) {
                System.out.println("Missing log: " + expectedLog);
            }
        }

        System.out.println("Log analysis complete.");
    }

    private static void generateExpectedLogs(Set<String> expectedLogs) {
        // This method should generate the expected logs based on your code structure
        // For simplicity, let's assume we have a predefined set of expected logs
        expectedLogs.add("Entering method ClassName.methodName at line X");
        expectedLogs.add("Exiting method ClassName.methodName at line X");
        expectedLogs.add("Entering if statement in ClassName.methodName at line X");
        expectedLogs.add("Entering loop in ClassName.methodName at line X");
        expectedLogs.add("Entering switch statement in ClassName.methodName at line X");
        expectedLogs.add("Entering case in switch statement in ClassName.methodName at line X");
    }
}