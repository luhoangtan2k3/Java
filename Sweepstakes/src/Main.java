import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SET List = new SET();
        Scanner Inputs = new Scanner(System.in);
        int Select;
        do{
            System.out.println("==========Menu==========");
            System.out.println(
                 "1 - Thêm mã số sinh viên.\n"
                +"2 - In danh sách mã số sinh viên.\n"
                +"3 - Xóa mã số sinh viên\n"
                +"4 - Kiểm tra mã số sinh viên có tồn tại hay không ???\n"
                +"5 - Xóa tất cả các mã số sinh viên\n"
                +"6 - Số lượng phiếu mã số sinh viên\n"
                +"7 - Mã số sinh viên mai mắn\n"
                +"0 - Kết thúc chương trình\n"
            );
            System.out.println("Nhập vào thao tác của bạn:");
            Select = Inputs.nextInt();
            Inputs.nextLine();
            switch(Select){
                case 1:{
                    System.out.println("Thêm mã số sinh viên:");
                    String MSSV = Inputs.nextLine();
                    List.Add(MSSV);
                    System.out.println("");
                    break;
                }
                case 2:{
                    if(List.Size()==0){
                        System.out.println("Danh sách mã số sinh viên rỗng:");
                    } else {
                        System.out.println("Xuất danh sách mã số sinh viên:");
                        List.Print();;
                        System.out.println("");
                    }
                    break;
                }
                case 3:{
                    if(List.Size()==0){
                        System.out.println("Danh sách mã số sinh viên rỗng:");
                    } else {
                        System.out.println("Nhập vào mã số sinh viên cần xóa:");
                        String MSSV_Delete = Inputs.nextLine();
                        if(List.Check(MSSV_Delete)==false){
                            System.out.println("Mã số sinh viên không tồn tại:");
                        } else {
                            List.Delete(MSSV_Delete);
                            System.out.println("Đã xóa: "+MSSV_Delete);
                        }
                        System.out.println("");
                    }
                    break;
                }
                case 4:{
                    System.out.println("Nhập vào mã số sinh viên cần kiểm tra:");
                    String MSSV_Check = Inputs.nextLine();
                    if(List.Check(MSSV_Check)==true){
                        System.out.println("Mã số sinh viên tồn tại.");
                    } else {
                        System.out.println("Mã số sinh viên không có.");
                    }
                    System.out.println("");
                    break;
                }
                case 5:{
                    if(List.Size()==0){
                        System.out.println("Danh sách mã số sinh viên rỗng:");
                    } else {
                        System.out.println("Đã xóa tất cả "+List.Size()+" mã số sinh viên:");
                        List.Clear();
                        System.out.println("");
                    }
                    break;
                }
                case 6:{
                    System.out.println("Danh sách tồn tại "+List.Size()+" mã số sinh viên:");
                    System.out.println();
                    break;
                }
                case 7:{
                    System.out.println("Sinh viên mai mắn: "+List.MSMM());
                    System.out.println("");
                    break;
                }
            }
        }while(Select!=0);
    }
}