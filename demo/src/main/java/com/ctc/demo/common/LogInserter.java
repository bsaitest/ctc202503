package com.ctc.demo.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogInserter {

    public static void main(String[] args) throws IOException {
        String directoryPath = "path/to/your/java/files";
        insertLogs(directoryPath);
    }

    public static void insertLogs(String directoryPath) throws IOException {
        Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(LogInserter::processFile);
    }

    private static void processFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            String className = path.getFileName().toString().replace(".java", "");
            StringBuilder newContent = new StringBuilder();
            String methodName = null;
            int lineNumber = 0;

            for (String line : lines) {
                lineNumber++;
                if (line.matches("\\s*public\\s+.*\\s+\\w+\\s*\\(.*\\)\\s*\\{")) {
                    methodName = extractMethodName(line);
                    newContent.append(line).append("\n");
                    newContent.append(String.format("System.out.println(\"Entering method %s.%s at line %d\");\n", className, methodName, lineNumber));
                } else if (line.matches("\\s*\\}")) {
                    if (methodName != null) {
                        newContent.append(String.format("System.out.println(\"Exiting method %s.%s at line %d\");\n", className, methodName, lineNumber));
                        methodName = null;
                    }
                    newContent.append(line).append("\n");
                } else if (line.matches("\\s*if\\s*\\(.*\\)\\s*\\{")) {
                    newContent.append(line).append("\n");
                    newContent.append(String.format("System.out.println(\"Entering if statement in %s.%s at line %d\");\n", className, methodName, lineNumber));
                } else if (line.matches("\\s*for\\s*\\(.*\\)\\s*\\{") || line.matches("\\s*while\\s*\\(.*\\)\\s*\\{") || line.matches("\\s*do\\s*\\{")) {
                    newContent.append(line).append("\n");
                    newContent.append(String.format("System.out.println(\"Entering loop in %s.%s at line %d\");\n", className, methodName, lineNumber));
                } else if (line.matches("\\s*switch\\s*\\(.*\\)\\s*\\{")) {
                    newContent.append(line).append("\n");
                    newContent.append(String.format("System.out.println(\"Entering switch statement in %s.%s at line %d\");\n", className, methodName, lineNumber));
                } else if (line.matches("\\s*case\\s+.*:")) {
                    newContent.append(line).append("\n");
                    newContent.append(String.format("System.out.println(\"Entering case in switch statement in %s.%s at line %d\");\n", className, methodName, lineNumber));
                } else {
                    newContent.append(line).append("\n");
                }
            }

            Files.write(path, newContent.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractMethodName(String line) {
        Pattern pattern = Pattern.compile("\\s*public\\s+.*\\s+(\\w+)\\s*\\(.*\\)\\s*\\{");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}