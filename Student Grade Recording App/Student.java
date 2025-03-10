
public class Student {

    // variable declaration
    private String Stud_No;
    private String Stud_Fullname;
    private String Stud_Gender;
    private int Stud_Filgrade;
    private int Stud_Enggrade;
    private int Stud_STgrade;
    private int Stud_Matgrade;
    private int Stud_Makgrade;
    private double Stud_Gwa;

    // Setter Method
    public void setStudNo(String Stud_No) {
        this.Stud_No = Stud_No;
    }

    public void setStudName(String Stud_Fullname) {
        this.Stud_Fullname = Stud_Fullname;
    }

    public void setStudGender(String Stud_Gender) {
        this.Stud_Gender = Stud_Gender;
    }

    public void setFilG(int Stud_Filgrade) {
        this.Stud_Filgrade = Stud_Filgrade;
    }

    public void setEngG(int Stud_Enggrade) {
        this.Stud_Enggrade = Stud_Enggrade;
    }

    public void setSTG(int Stud_STgrade) {
        this.Stud_STgrade = Stud_STgrade;
    }

    public void setMatG(int Stud_Matgrade) {
        this.Stud_Matgrade = Stud_Matgrade;
    }

    public void setMakG(int Stud_Makgrade) {
        this.Stud_Makgrade = Stud_Makgrade;
    }

    public void setGwa(double Stud_Gwa) {
        this.Stud_Gwa = Stud_Gwa;
    }

    // Getter Methods
    public String getStudNo() {
        return this.Stud_No;
    }

    public String getStudName() {
        return this.Stud_Fullname;
    }

    public String getStudGender() {
        return this.Stud_Gender;
    }

    public int getFilG() {
        return this.Stud_Filgrade;
    }

    public int getEngG() {
        return this.Stud_Enggrade;
    }

    public int getMakG() {
        return this.Stud_Makgrade;
    }

    public int getMatG() {
        return this.Stud_Matgrade;
    }

    public int getSTG() {
        return this.Stud_STgrade;
    }

    public double getGwa() {
        return this.Stud_Gwa;
    }

    // compute the gwa
    public double computeGwa() {
        double gwa = 0;
        gwa = ((double) Stud_Enggrade * 1.5 + (double) Stud_Filgrade * 1.5 + (double) Stud_Makgrade * 4.0
                + (double) Stud_Matgrade * 2.0 + (double) Stud_STgrade * 2.0) / 11;

        return gwa;
    }

}