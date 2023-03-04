import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MAP Dictionary = new MAP();
        Scanner Inputs = new Scanner(System.in);
        int Select = 0;
        do{
            System.out.println("==========Menu==========");
            System.out.println(
                 "1 - Thêm từ điển vào danh sách\n"
                +"2 - Xóa từ điển khỏi danh sách\n"
                +"3 - Tra từ điển ý nghĩa của key\n"
                +"4 - In ra danh sách từ khóa\n"
                +"5 - In ra số lượng từ đã nhập\n"
                +"6 - Xóa tất cả từ điển\n"
            );
            System.out.println("Nhập vào thao tác của bạn:");
            Select = Inputs.nextInt();
            Inputs.nextLine();
            switch(Select){
                case 1:{
                    System.out.println("Nhập vào Key:");
                    String Key = Inputs.nextLine();
                    System.out.println("Nhập vào Vocabulary:");
                    String Vocabulary = Inputs.nextLine();
                    Dictionary.Add(Key, Vocabulary);
                    System.out.println("");
                    break;
                }
                case 2:{
                    if(Dictionary.Size()==0){
                        System.out.println("Danh sách rỗng:");
                    } else {
                        System.out.println("Nhập vào key cần xóa:");
                        String Delete_Key = Inputs.nextLine();
                        Dictionary.Delete(Delete_Key);
                        System.out.println("Đã xóa key: "+Delete_Key);
                    }
                    System.out.println("");
                    break;
                }
                case 3:{
                    if(Dictionary.Size()==0){
                        System.out.println("Danh sách rỗng:");
                    } else {
                        System.out.println("Nhập vào key tra cứu:");
                        String Look_up_dictionary = Inputs.nextLine();
                        System.out.println("Vocabulary= "+Dictionary.Look_up_dictionary(Look_up_dictionary));
                    }
                    System.out.println("");
                    break;
                }
                case 4:{
                    if(Dictionary.Size()==0){
                        System.out.println("Danh sách rỗng:");
                    } else {
                        System.out.println("Danh sách key:");
                        Dictionary.Printf();
                    }
                    System.out.println("");
                    break;
                }
                case 5:{
                    System.out.println("Số lượng key đã nhập: "+Dictionary.Size());
                    System.out.println("");
                    break;
                }
                case 6:{
                    if(Dictionary.Size()==0){
                        System.out.println("Danh sách rỗng:");
                    } else {
                        System.out.println("Đã xóa sạch: "+Dictionary.Size()+" Key");
                        Dictionary.Clear();
                    }
                    System.out.println("");
                    break;
                }
            }
        }while(Select!=0);
    }
}