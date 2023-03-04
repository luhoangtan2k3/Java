import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller{
    ArrayList<Student> List = new ArrayList<Student>();

    // Thêm sinh viên vào danh sách sinh viên.
    public void Add_Student(Student Student){
        this.List.add(Student);
    }
    // Xuất danh sách sinh viên ra màn hình.
    public void Print_Student(){
        for ( Student Student : List ) {
            System.out.println(Student);
        }
    }
    // Kiểm tra danh sách sinh viên có rỗng hay không ???
    public boolean Empty_Student(){
        return this.List.isEmpty();
    }
    // Kiểm tra có bao nhiêu thành viên trong danh sách.
    public int Size_Student(){
        return this.List.size();
    }
    // Xóa tất cả thành viên trong danh sách sinh viên.
    public void Delete_All_Student(){
        this.List.removeAll(List);
    }
    // Kiểm tra sinh viên đc chỉ định có trong danh sách hay không ???
    public boolean Yes_of_no(Student Student){
        return this.List.contains(Student);
    }
    // Xóa sinh viên đc chỉ định khỏi danh sách sinh viên.
    public boolean Delete_Student(Student Student){
        return this.List.remove(Student);
    }
    // Tìm kiếm tất cả sinh viên theo tên.
    public void Search_Student(String Name){
        for(Student Student : List){
            if(Student.getName().indexOf(Name)>=0){
                System.out.println(Student);
            }
        }
    }
    // Xuất danh sách sinh viên có điểm trung bình giảm/tăng dần.
    public void Sort_student(){
        Collections.sort(List,new Comparator<Student>() {
        @Override
        public int compare(Student SV1, Student Sv2) {
            if(SV1.getDiemTB()>Sv2.getDiemTB()){
                return 1;
            } else if(SV1.getDiemTB()>Sv2.getDiemTB()) {
                return 0;
            } else {
                return -1;
            }
        }
        });
    }
    public void Write_File(File Path){
        try {
            FileWriter FW = new FileWriter(Path,StandardCharsets.UTF_8);
            BufferedWriter BW = new BufferedWriter(FW);
            for(Student Arrays : List){
                BW.write(Arrays.toString());
                BW.newLine();
            }
            BW.close();
            FW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Read_File(File Path){
        try {
            FileReader FR = new FileReader(Path, StandardCharsets.UTF_8);
            BufferedReader BR = new BufferedReader(FR);
            while(true){
                String Line = BR.readLine();
                if(Line==null){
                    break;
                }
                System.out.println(Line);
            }
            BR.close();
            FR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}