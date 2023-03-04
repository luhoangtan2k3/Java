import java.io.File;
import java.util.Scanner;
public class RUN {
    public static void main(String[] args){
        Scanner Inputs = new Scanner(System.in);
        System.out.println("Nhập vào đường dẫn thư mục hoặc tệp tin");
        String Path_Folder = Inputs.nextLine();
        FILE Folder = new FILE(Path_Folder); FILE Directory = new FILE();
        int Select;
        do{
            System.out.println("====================Menu====================");
            System.out.println(
                "1 - Kiểm tra folder/file có tồn tại hay không.\n"
                +"2 - Kiểm tra folder/file có thể chạy được hay không.\n"
                +"3 - Kiểm tra folder/file có thể đọc được hay không.\n"
                +"4 - Kiểm tra folder/file có thể viết được hay không.\n"
                +"5 - In ra màn hình đường dẫn folder/file.\n"
                +"6 - In ra màn hình tên folder/file.\n"
                +"7 - Kiểm tra đây là folder hay file.\n"
                +"8 - In ra màn hình danh sách folder/file con lớp thứ 1.\n"
                +"9 - In ra màn hình sơ đồ danh sách theo trật tự sắp xếp.\n"
                +"10 - Tạo một thư mục mới.\n"
                +"11 - Tạo một tệp tin mới.\n"
                +"12 - Xóa tất cả dữ liệu trong thư mục từ đường dẫn.\n"
                +"13 - Đổi tên thư mục,tệp tin.\n"
                +"14 - Di chuyển thư mục,tập tin.\n"
                +"15 - Sao chép thư mục,tập tin.\n"
                +"16 - Ghi dữ liệu văn bản vào file.txt.\n"
                +"17 - Đọc dữ liệu văn bản từ file.txt.\n"
                +"0 - Kết thúc chương trình.\n"
            );
            System.out.print("Thực hiện theo tác của bạn: ");
            Select = Inputs.nextInt();
            Inputs.nextLine();
            System.out.println("");
            switch(Select){
                case 1:{
                    if(Folder.Exists()){
                        System.out.println("Thư mục,tệp tin hiện đang tồn tại:");
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                        System.out.println("");
                        break;
                }
                case 2:{
                    if(Folder.Exists()){
                        if(Folder.Test_Run()){
                            System.out.println("Thư mục,tệp tin có thể chạy:");
                        } else {
                            System.out.println("Thư mục,tệp tin không thể chạy:");
                        }
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                        System.out.println("");
                        break;
                }
                case 3:{
                    if(Folder.Exists()){
                        if(Folder.Test_Read()){
                            System.out.println("Thư mục,tệp tin có thể đọc:");
                        } else {
                            System.out.println("Thư mục,tệp tin không thể đọc");
                        }
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 4:{
                    if(Folder.Exists()){
                        if(Folder.Test_Write()){
                            System.out.println("Thư mục,tệp tin có thể viết:");
                        } else {
                            System.out.println("Thư mục,tệp tin không thể viết");
                        }
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 5:{
                    if(Folder.Exists()){
                        System.out.print("Đường dẫn folder/file: ");
                        Folder.Print_Path();
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 6:{
                    if(Folder.Exists()){
                        System.out.print("Tên của folder/file: ");
                        Folder.Printf_Name();
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 7:{
                    if(Folder.Exists()){
                        if(Folder.Folder_Or_File()=="Folder"){
                            System.out.println("Đây là một thư mục:");
                        } else if(Folder.Folder_Or_File()=="File"){
                            System.out.println("Đây là một tệp tin:");
                        }
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 8:{
                    if(Folder.Exists()){
                        System.out.println("Danh sách thư mục,tập tin con:");
                        Folder.Print_List();
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 9:{
                    if(Folder.Exists()){
                        System.out.println("Danh sách tất cả thư mục,tập tin bên trong đường dẫn:");
                        Folder.Directory_List_Print();
                    } else {
                        System.out.println("Thư mục,tệp tin không tồn tại:");
                    }
                    System.out.println("");
                    break;
                }
                case 10:{
                    System.out.println("Nhập vào folder cần tạo:");
                    String Path = Inputs.nextLine();
                    File Creat_Folder = new File(Path);
                    if(Directory.Creat_Folder(Creat_Folder)){
                        System.out.println("Folder "+Creat_Folder.getAbsolutePath()+" đã được tạo:");
                    } else {
                        System.out.println("Không tạo được folder:");
                    }
                    System.out.println("");
                    break;
                }
                case 11:{
                    System.out.println("Nhập vào file(.docx,.pdf,.text,.ppt,...) cần tạo:");
                    String Path = Inputs.nextLine();
                    File Creat_File = new File(Path);
                    Directory.Creat_File(Creat_File);
                    System.out.println("");
                    break;
                }
                case 12:{
                    System.out.println("Nhập vào đường dẫn thư mục hoặc tệp tin cần xóa:");
                    String Path = Inputs.nextLine();
                    File Delete_Data = new File(Path);
                    Directory.Delete_Data(Delete_Data);
                    System.out.println("");
                    break;
                }
                case 13:{
                    System.err.println("Nhập vào đường dẫn thư mục,tệp tin cần thay đổi tên:");
                    String Initial = Inputs.nextLine();
                    File Path_Initial = new File(Initial);
                    System.out.println("Nhập vào đường dẫn thư mục,tệp tin sau khi thay đổi:");
                    String Rename = Inputs.nextLine();
                    File Path_Rename = new File(Rename);
                    if(Directory.Rename(Path_Initial, Path_Rename)){
                        if(Path_Rename.isDirectory()){
                            System.out.println("Đã đổi thư mục từ "+Path_Initial.getName()+" thành "+Path_Rename.getName());
                        } else if(Path_Rename.isFile()){
                            System.out.println("Đã đổi tệp tin từ "+Path_Initial.getName()+" thành "+Path_Rename.getName());
                        }
                    } else {
                        System.out.println("Có lỗi thi thực hiện,mời bạn kiểm tra lại.");
                    }
                    System.out.println("");
                    break;
                }
                case 14:{
                    System.err.println("Nhập vào đường dẫn thư mục,tệp tin cần di chuyển:");
                    String Initial = Inputs.nextLine();
                    File Path_Initial = new File(Initial);
                    System.out.println("Nhập vào đường dẫn thư mục,tệp tin sau khi di chuyển:");
                    String Cut = Inputs.nextLine();
                    File Path_Cut = new File(Cut);
                    Directory.Cut(Path_Initial, Path_Cut);
                    System.out.println("");
                    break;
                }
                case 15:{
                    System.err.println("Nhập vào đường dẫn thư mục,tệp tin cần sao chép:");
                    String Initial = Inputs.nextLine();
                    File Path_Initial = new File(Initial);
                    System.out.println("Nhập vào đường dẫn thư mục,tệp tin sau khi sao chép:");
                    String Copy = Inputs.nextLine();
                    File Path_Copy = new File(Copy);
                    Directory.Copy(Path_Initial, Path_Copy);
                    System.out.println("");
                    break;
                }
                case 16:{
                    System.out.println("Nhập vào đường dẫn file.txt của bạn cần ghi dữ liệu:");
                    String Path = Inputs.nextLine();
                    File Write_Text = new File(Path);
                    System.out.println("Nhập vào dữ liệu văn bản của bạn cần ghi vào file.txt:");
                    String Text = Inputs.nextLine();
                    Directory.Write(Write_Text, Text);
                    System.out.println("");
                    break;
                }
                case 17:{
                    System.out.println("Nhập vào đường dẫn file.txt của bạn cần đọc dữ liệu:");
                    String Path = Inputs.nextLine();
                    File Read_Text = new File(Path);
                    Directory.Read(Read_Text);
                    System.out.println("");
                    break;
                }
                case 0:{
                    System.out.println("Chúc bạn có một ngày vui vẻ,xin chào và hẹn gặp lại.\n");
                    break;
                }
                default:{
                    System.out.println("Bạn đã thực hiện sai cú pháp,mời bạn thực hiện lại:\n");
                }
            }
        }while(Select!=0);
    }
}