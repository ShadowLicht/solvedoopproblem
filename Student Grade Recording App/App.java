
//library
import java.util.ArrayList;

//class
public class App {

    // main method
    public static void main(String[] args) throws Exception {

        // arraylist of object declaration
        ArrayList<Student> student = new ArrayList<>();

        // add all existing student records in a file into arraylist student
        student.addAll(StudentRecord.loadStudentRecord());

        // Variable declaration
        char input;
        int limit;
        // Object Declaration
        Student stud = new Student();
        // while loop that display menu repeatedly until the user decided to quit the
        // App
        while (true) {
            // Display the menu options and prompt the user to enter their choice
            System.out.println("\n\nSTUDENT GRADE RECORDING APPLICATION");
            System.out.println("-----------------------------------");
            System.out.println("Main Menu:");
            System.out.println("\t[A] Add Student Grade Record");
            System.out.println("\t[B] Update Student Grade Record");
            System.out.println("\t[C] Delete Student Grade Record");
            System.out.println("\t[D] View Student Grade Records");
            System.out.println("\t[E] View Student Grade Ranking");
            System.out.println("\t[F] View Top N Students");
            System.out.println("\t[X] Quit Application");
            System.out.print("\n\t>> Enter your choice: ");
            input = ConsInput.getCharinp();
            ConsInput.skipl();

            // Execute the appropriate action based on the user's input
            switch (input) {
                case 'A':
                    // call the method getStudentRecord to get student data from the user
                    stud = getStudentRecord(student);
                    // add object stud including its data into Arraylist student
                    student.add(stud);
                    break;
                case 'B':
                    // call the method upddateStudentData with the parameter Arraylist of object
                    // student to update data in StudentRecords
                    StudentRecord.updateStudentData(student);
                    break;
                case 'C':
                    // call the method deleteStudentData with the parameter Arraylist of object
                    // student to delete data in StudentRecords
                    StudentRecord.deleteStudentData(student);
                    break;
                case 'D':
                    // call the method viewStudentRecords with the parameter Arraylist of object
                    // student to display data in StudentRecords in alphabetical order
                    StudentRecord.viewStudentRecords(student);
                    break;
                case 'E':
                    // call the method viewStudentRanking with the parameter Arraylist of object
                    // student to display data in StudentRecords base on their gwa from highest to
                    // lowest
                    StudentRecord.viewStudentRanking(student, 0);
                    break;
                case 'F':
                    // call the method viewStudentRanking with the parameter Arraylist of object
                    // student to display top N data in StudentRecords base on their gwa from
                    // highest to lowest
                    System.out.print("Enter the number of student: ");
                    limit = ConsInput.getIntinp();
                    StudentRecord.viewStudentRanking(student, limit);
                    break;
                case 'X':
                    // call the method saveStudentData that save student data in their database and
                    // StudentRecordTable Then Exit
                    System.out.println("\n-- Thank you for using the application");
                    StudentRecord.saveStudentData(student);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // set the data entered by the user in the setter method in Student
    static Student getStudentRecord(ArrayList<Student> students) {
        // Object declaration
        Student s = new Student();
        // Variable declaration
        String studno = "";
        String studname = "";

        System.out.print("Enter the Student Number: ");
        studno = ConsInput.getStrinp();
        // check if the Student number exist in the Database
        while (StudentRecord.compareData(students, studno) != -1) {
            // if data exist ask the user to enter again the student Number
            System.out.println("Data exists!!!");
            System.out.print("Enter the Student Number: ");
            studno = ConsInput.getStrinp();
        }
        s.setStudNo(studno);
        // check if the Student name exist in the Database
        System.out.print("Enter the Name (LS, FN MI): ");
        studname = ConsInput.getStrinp();
        while (StudentRecord.compareName(students, studname) != -1) {
            // if data exist ask the user to enter again the student name
            System.out.println("Data exists!!!");
            System.out.print("Enter the Name (LS, FN MI): ");
            studname = ConsInput.getStrinp();
        }
        s.setStudName(studname);
        System.out.print("Enter the Gender: ");
        s.setStudGender(ConsInput.getStrinp());
        System.out.print("Enter Grades in Science & Technology: ");
        s.setSTG(ConsInput.getIntinp());
        System.out.print("Enter Grades in Math: ");
        s.setMatG(ConsInput.getIntinp());
        System.out.print("Enter Grades in English: ");
        s.setEngG(ConsInput.getIntinp());
        System.out.print("Enter Grades in Filipino: ");
        s.setFilG(ConsInput.getIntinp());
        System.out.print("Enter Grades in Makabayan: ");
        s.setMakG(ConsInput.getIntinp());
        s.setGwa(s.computeGwa());

        // return the object s
        return s;
    }

}
