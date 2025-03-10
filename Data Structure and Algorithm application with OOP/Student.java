public class Student {
    private String name;
    private char gender;
    private String stud_no;

    public Student(String stud_no, String name, char gender) {
        this.stud_no = stud_no;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getStud_no() {
        return stud_no;
    }

    public void setStud_no(String stud_no) {
        this.stud_no = stud_no;
    }

    @Override
    public String toString() {
        return "(" + stud_no + ") " + name + " [" + gender + "] ";
    }
}
