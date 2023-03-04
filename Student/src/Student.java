import java.util.Objects;

public class Student{
    private String Name;
    private String MSSV;
    private int Namsinh;
    private double DiemTB;
    public Student(String name, String MSSV, int namsinh, double diemTB) {
        this.Name = name;
        this.MSSV = MSSV;
        this.Namsinh = namsinh;
        this.DiemTB = diemTB;
    }
    public Student(String MSSV){
        this.MSSV = MSSV;
    }
    public String getName() {
        return this.Name;
    }
    public String getMSSV() {
        return this.MSSV;
    }
    public int getNamsinh() {
        return this.Namsinh;
    }
    public double getDiemTB() {
        return this.DiemTB;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }
    public void setNamsinh(int Year) {
        this.Namsinh = Year;
    }
    public void setDiemTB(double DTB) {
        this.DiemTB = DTB;
    }
    @Override
    public boolean equals(Object Student) {
        if(Student == null || !(Student instanceof Student)){
            return false;
        }
        Student SV = (Student)Student;
        return Objects.equals(this.MSSV, SV.MSSV);
    }
    @Override
    public String toString() {
        return "Name: "+this.Name+"   MSSV: "+this.MSSV+"   Namsinh: "+this.Namsinh+"   DiemTB: "+this.DiemTB;
    }
}