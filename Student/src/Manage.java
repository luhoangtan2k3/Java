import java.io.File;
import java.util.Scanner;

public class Manage {
    public static void main(String[] args) {
        Scanner Inputs = new Scanner(System.in);
        Controller Student = new Controller();
        int Select;
        do{
            System.out.println(
                 "1-Thêm danh sách sinh viên vào ArrayList.\n"
                +"2-Xuất danh sách sinh viên ra màn hình.\n"
                +"3-Kiểm tra danh sách sinh viên có rỗng hay không.\n"
                +"4-Tồn tại bao nhiêu sinh viên trong danh sách.\n"
                +"5-Xóa tất cả các sinh viên trong danh sách này.\n"
                +"6-Kiểm tra sinh viên cụ thể có trong danh sách hay không.\n"
                +"7-Xóa sinh viên khỏi danh sách bằng mã số sinh viên.\n"
                +"8-Tìm kiếm sinh viên bằng tên.\n"
                +"9-Xuất danh sách sinh viên theo thứ tự.\n"
                +"10-Ghi danh sách sinh viên vào file.txt.\n"
                +"11-Đọc danh sách sinh viên từ file.txt.\n"
            );
            System.out.print("Chọn thao tác thực hiện:");
            Select = Inputs.nextInt();
            System.out.println("");
            String Space = Inputs.nextLine();
            switch(Select){
                case 1:{
                    System.out.println("Nhập vào họ và tên:");
                    String Name = Inputs.nextLine();
                    System.out.println("Nhập vào mã số sinh viên:");
                    String MSSV = Inputs.nextLine();
                    System.out.println("Nhập vào năm sinh:");
                    int NamSinh = Inputs.nextInt();
                    System.out.println("Nhập vào điểm trung bình:");
                    double DiemTB = Inputs.nextDouble();
                    Student Student_Management = new Student(Name, MSSV, NamSinh, DiemTB);
                    Student.Add_Student(Student_Management);
                    System.out.println("");
                    break;
                }
                case 2:{
                    if(Student.Empty_Student()==false){
                        System.out.println("Xuất danh sách sinh viên ra màn hình:");
                        Student.Print_Student();
                    } else {
                        System.out.println("Danh sách sinh viên rỗng");
                    }
                    System.out.println("");
                    break;
                }
                case 3:{
                    if(Student.Empty_Student()){
                        System.out.println("Danh sách sinh viên rỗng:");
                    } else {
                        System.out.println("Danh sách sinh viên tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 4:{
                    if(Student.Empty_Student()==false){
                        System.out.println("Số lượng sinh viên là "+Student.Size_Student());
                    } else {
                        System.out.println("Danh sách sinh viên rỗng:");
                    }
                    System.out.println("");
                    break;
                }
                case 5:{
                    if(Student.Empty_Student()==false){
                        System.out.println("==> Removed all students from the student list:");
                        Student.Delete_All_Student();
                    } else {
                        System.out.println("Danh sách sinh viên rỗng:");
                    }
                    System.out.println("");
                    break;
                }
                case 6:{
                    if(Student.Empty_Student()==false){
                        System.out.println("Nhập vào mã số sinh viên:");
                        String MSSV_Test = Inputs.nextLine();
                        Student MSSV = new Student(MSSV_Test);
                        if(Student.Yes_of_no(MSSV)){
                            System.out.println("Sinh viên này có tồn tại.");
                        } else {
                            System.out.println("Sinh viên này không tồn tại.");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng:");
                    }
                    System.out.println("");
                    break;
                }
                case 7:{
                    if(Student.Empty_Student()==false){
                        System.out.println("Nhập vào mã số sinh viên:");
                        String MSSV_Test = Inputs.nextLine();
                        Student MSSV = new Student(MSSV_Test);
                        if(Student.Delete_Student(MSSV)){
                            System.out.println("Đã xóa.");
                        } else {
                            System.out.println("Chưa xóa hoặc không tồn tại");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng:");
                    }
                    System.out.println("");
                    break;
                }
                case 8:{
                    if(Student.Empty_Student()==false){
                        System.out.println("Nhập vào tên sinh viên:");
                        String Name_Test = Inputs.nextLine();
                        Student.Search_Student(Name_Test);
                    } else {
                        System.out.println("Danh sách sinh viên rỗng:");
                    }
                    System.out.println("");
                    break;
                }
                case 9:{
                    if(Student.Empty_Student()==false){
                        System.out.println("Xuất danh sách sinh viên theo thứ tự:");
                        Student.Sort_student();
                        Student.Print_Student();
                    } else {
                        System.out.println("Danh sách sinh viên rỗng:");
                    }
                    System.out.println("");
                    break;
                }
                case 10:{
                    System.out.println("Nhập vào đường dẫn file:");
                    String Path = Inputs.nextLine();
                    File Path_File = new File(Path);
                    Student.Write_File(Path_File);
                    System.out.println("");
                    break;
                }
                case 11:{
                    System.out.println("Nhập vào đường dẫn file:");
                    String Path = Inputs.nextLine();
                    File Path_File = new File(Path);
                    Student.Read_File(Path_File);
                    System.out.println("");
                    break;
                }
                case 0:{
                    System.out.println("Xin chào và hẹn gặp lại,chúc bạn vui vẻ.\n");
                    break;
                }
                default:{
                    System.out.println("Thao tác của bạn không hợp lệ:\n");
                    break;
                }
            }
        }while(Select!=0);
    }
}