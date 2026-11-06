// https://github.com/DanielMbah/MaxCGPA.java.git

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxCGPA {
    public static void main(String[] args) {

        String fileName = "students.txt";
        String topStudent = "";
        double maxCGPA = -1;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");

                double cgpa = Double.parseDouble(
                        parts[parts.length - 1]
                );

                String name = String.join(" ",
                        java.util.Arrays.copyOf(parts, parts.length - 1));

                if (cgpa > maxCGPA) {
                    maxCGPA = cgpa;
                    topStudent = name;
                }
            }

            System.out.println("Student with maximum CGPA: " + topStudent);
            System.out.println("Maximum CGPA: " + maxCGPA);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
