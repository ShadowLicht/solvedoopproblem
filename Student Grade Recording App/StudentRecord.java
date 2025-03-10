import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentRecord {

    public static ArrayList<Student> loadStudentRecord() {
        ArrayList<Student> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("StudentRecord.txt"))) {
            while (scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split("@");
                Student student = new Student();
                student.setStudNo(fields[0]);
                student.setStudName(fields[1]);
                student.setStudGender(fields[2]);
                student.setSTG(Integer.parseInt(fields[3]));
                student.setMatG(Integer.parseInt(fields[4]));
                student.setEngG(Integer.parseInt(fields[5]));
                student.setFilG(Integer.parseInt(fields[6]));
                student.setMakG(Integer.parseInt(fields[7]));
                student.setGwa(Double.parseDouble(fields[8]));
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

    public static void viewStudentRecords(ArrayList<Student> students) {
        Collections.sort(students, (s1, s2) -> s1.getStudName().compareTo(s2.getStudName()));
        displayStudentData(students, 0);
    }

    public static void viewStudentRanking(ArrayList<Student> students, int lim) {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getGwa(), s1.getGwa()));
        displayStudentData(students, lim);
    }

    // a method that will update student data in the database
    public static void updateStudentData(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Student No. of the record you want to update: ");
        String studNo = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudNo().equals(studNo)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Student record not found.");
            return;
        }
        while (true) {
            System.out.println("\nStudent data:");
            System.out.println("Student Number: " + students.get(index).getStudNo());
            System.out.println("Student Name: " + students.get(index).getStudName());
            System.out.println("Gender: " + students.get(index).getStudGender());
            System.out.println("S&T Grade: " + students.get(index).getSTG());
            System.out.println("Mathematics Grade: " + students.get(index).getMatG());
            System.out.println("English Grade: " + students.get(index).getEngG());
            System.out.println("Filipino Grade: " + students.get(index).getFilG());
            System.out.println("MAK Grade: " + students.get(index).getMakG());
            System.out.println("GWA: " + students.get(index).getGwa());
            System.out.println("\nEnter the field you want to update or enter 'done' to save the changes:");
            String field = scanner.nextLine();
            if (field.equalsIgnoreCase("done")) {
                break;
            }
            if (field.equalsIgnoreCase("student number")) {
                System.out.print("Enter the new student number: ");
                students.get(index).setStudNo(scanner.nextLine());
            } else if (field.equalsIgnoreCase("student name")) {
                System.out.print("Enter the new student name: ");
                students.get(index).setStudName(scanner.nextLine());
            } else if (field.equalsIgnoreCase("gender")) {
                System.out.print("Enter the new gender: ");
                students.get(index).setStudGender(scanner.nextLine());
            } else if (field.equalsIgnoreCase("s&t grade")) {
                System.out.print("Enter the new S&T grade: ");
                students.get(index).setSTG(scanner.nextInt());
                scanner.nextLine(); // consume the newline character
            } else if (field.equalsIgnoreCase("mathematics grade")) {
                System.out.print("Enter the new Mathematics grade: ");
                students.get(index).setMatG(scanner.nextInt());
                scanner.nextLine(); // consume the newline character
            } else if (field.equalsIgnoreCase("english grade")) {
                System.out.print("Enter the new English grade: ");
                students.get(index).setEngG(scanner.nextInt());
                scanner.nextLine(); // consume the newline character
            } else if (field.equalsIgnoreCase("filipino grade")) {
                System.out.print("Enter the new Filipino grade: ");
                students.get(index).setFilG(scanner.nextInt());
                scanner.nextLine(); // consume the newline character
            } else if (field.equalsIgnoreCase("mak grade")) {
                System.out.print("Enter the new MAK grade: ");
                students.get(index).setMakG(scanner.nextInt());
                scanner.nextLine(); // consume the newline character
            } else {
                System.out.println("Invalid field name. Please try again.");
            }
            students.get(index).setGwa(students.get(index).computeGwa());
        }

        System.out.println("Student record updated successfully.");
    }

    // A method that delete Student Data
    public static void deleteStudentData(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Student No. of the record you want to delete: ");
        String studNo = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudNo().equals(studNo)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Student record not found.");
            return;
        }
        students.remove(index);
        System.out.println("Student record deleted successfully.");
    }

    // save all the data added and changes made in the Records in a file
    public static void saveStudentData(ArrayList<Student> students) {
        // declare 2 files
        // for the database
        File f1 = new File("StudentRecord.txt");
        // for the Record Table
        File f2 = new File("StudentRecordTable.txt");
        // try to createNewFile and check if it exist
        try {

            if (f1.createNewFile() || f2.createNewFile()) {
                System.out.println("File created and data successfully saved");
            } else {
                System.out.println("Data successfully saved");
            }
            // catch and display error
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        // Save the Data in ArrayList object to the database
        try {
            PrintWriter writer = new PrintWriter(f1);
            for (Student student : students) {
                writer.println(String.join("@",
                        student.getStudNo(),
                        student.getStudName(),
                        student.getStudGender(),
                        Integer.toString(student.getSTG()),
                        Integer.toString(student.getMatG()),
                        Integer.toString(student.getEngG()),
                        Integer.toString(student.getFilG()),
                        Integer.toString(student.getMakG()),
                        Double.toString(student.getGwa())));
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // call the method that will save the data in the Record table
        saveStudentDataTable(students, f2);
    }

    // a method that will save student data in a tabular format in the record table
    public static void saveStudentDataTable(ArrayList<Student> students, File f) {

        // try to write the data in a tabular format in the record table
        try {
            PrintWriter writer = new PrintWriter(f);
            int i = 1;

            writer.println(
                    "+----+----------+---------------------------------------+--------+-----+-----+-----+-----+-----+-------+");
            writer.println(
                    "| NO | STUD NO. | NAME                                  | GENDER | S&T | MAT | ENG | FIL | MAK | GWA   |");
            writer.println(
                    "+----+----------+---------------------------------------+--------+-----+-----+-----+-----+-----+-------+");

            for (Student s : students) {
                writer.printf("| %02d ", i);
                writer.print("| " + s.getStudNo());
                writer.printf(" | %-" + 36 + "s ", s.getStudName());
                writer.printf(" | %-" + 6 + "s", s.getStudGender());
                // System.out.print(" | " + + "\t\t");
                if (s.getSTG() < 74)
                    writer.print(" | F ");
                else
                    writer.print(" | " + s.getSTG());
                if (s.getMatG() < 74)
                    writer.print("  | F ");
                else
                    writer.print("  | " + s.getMatG());
                if (s.getEngG() < 74)
                    writer.print("  | F ");
                else
                    writer.print("  | " + s.getEngG());
                if (s.getFilG() < 74)
                    writer.print("  | F ");
                else
                    writer.print("  | " + s.getFilG());
                if (s.getMakG() < 74)
                    writer.print("  | F ");
                else
                    writer.print("  | " + s.getMakG());
                if (s.getGwa() < 74)
                    writer.print("  |   F  ");
                else
                    writer.printf("  | %.2f", s.getGwa());
                writer.println(
                        " |\n+----+----------+---------------------------------------+--------+-----+-----+-----+-----+-----+-------+");
                i++;
            }
            // close the writer
            writer.close();
            // catch and display the error
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // a method that will display data in a tabular format
    static void displayStudentData(ArrayList<Student> students, int lim) {
        System.out.printf("%5s %10s %30s %8s %5s %5s %5s %5s %5s %6s\n", "NO", "STUD NO.", "NAME", "GENDER", "S&T",
                "MAT", "ENG", "FIL", "MAK", "GWA");
        System.out.println(
                "-----------------------------------------------------------------------------------------------");

        int i = 1;
        // loop will iterate over each element in the fields and assign it to the
        // object s
        // this loop will get the data in the Arraylist student and display each data
        // inside it
        for (Student s : students) {
            System.out.printf("%5d %10s %30s %8s ", i, s.getStudNo(), s.getStudName(), s.getStudGender());
            if (s.getSTG() < 74) {
                System.out.print(" F ");
            } else {
                System.out.printf("%5d", s.getSTG());
            }
            if (s.getMatG() < 74) {
                System.out.print(" F ");
            } else {
                System.out.printf("%5d", s.getMatG());
            }
            if (s.getEngG() < 74) {
                System.out.print(" F ");
            } else {
                System.out.printf("%5d", s.getEngG());
            }
            if (s.getFilG() < 74) {
                System.out.print(" F ");
            } else {
                System.out.printf("%5d", s.getFilG());
            }
            if (s.getMakG() < 74) {
                System.out.print(" F ");
            } else {
                System.out.printf("%5d", s.getMakG());
            }
            if (s.getGwa() < 74) {
                System.out.print("   F  ");
            } else {
                System.out.printf("%6.2f", s.getGwa());
            }
            System.out.println();
            if (i == lim) {
                break;
            }
            i++;
        }
    }

    // a method that will check if data exist and return the index
    public static int compareData(ArrayList<Student> students, String studno) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudNo().equals(studno)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // a method that will check if the student name exist
    public static int compareName(ArrayList<Student> students, String studname) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudName().equals(studname)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
