import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Over_Under {
    public static void main(String[] args) {
        System.out.println("Chào mừng bạn đến với game tài xỉu");
        double User_account = 1000000;
        Locale Locale = new Locale("vi", "VN");
        NumberFormat Money = NumberFormat.getCurrencyInstance(Locale);
        Scanner Inputs = new Scanner(System.in);
        int Option = 0;
        // Nhập phím 1 để chơi hoặc  phím bất kỳ để thoát.
        do{
            System.out.println("Vui lòng chọn hành động của bạn:");
            System.out.println("Nhập vào 1 để chơi,nhập bất kỳ để thoát:");
            Option = Inputs.nextInt();
            System.out.println("");
            if(Option==1){
                System.out.println("Trò chơi bắt đầu!");
                System.out.println("Tài khoản của bạn: "+Money.format(User_account));
                System.out.println("Bạn muốn cược bao nhiêu???");
                //Nhập vào số tiền mà bạn muốn đặt cược.
                double Amount_bet = 0;
                do{
                    System.out.println("Số tiền cược 0<x<="+Money.format(User_account));
                    Amount_bet = Inputs.nextDouble();
                }while(Amount_bet<=0 || Amount_bet>User_account);
                int Select =0;
                // Lựa chọn Tài hoặc Xỉu để trò chơi bắt đầu.
                do{
                    System.out.println("Chọn tài(1) hoặc xỉu(2)");
                    Select = Inputs.nextInt();
                }while(Select != 1 && Select != 2);
                Random Dice_1 = new Random();
                Random Dice_2 = new Random();
                Random Dice_3 = new Random();
                int Value_1 = Dice_1.nextInt(5)+1;
                int Value_2 = Dice_2.nextInt(5)+1;
                int Value_3 = Dice_3.nextInt(5)+1;
                int Total = Value_1 + Value_2 + Value_3;
                System.out.println("Result: "+Value_1+" - "+Value_2+" - "+Value_3);
                // Kết quả của trò chơi.
                if(Total==3||Total==18){
                    System.out.println("Total = "+Total+"==> You lose - the house wins");
                    User_account = User_account-Amount_bet;
                    System.out.println("User account: "+Money.format(User_account));
                } else if(Total>=4&&Total<=10){
                    System.out.println("Total = "+Total+"==>Under");
                    if(Select==2){
                        System.out.println("You win");
                        User_account = User_account + Amount_bet;
                        System.out.println("User_account: "+Money.format(User_account));
                    } else {
                        System.out.println("You lose");
                        User_account = User_account - Amount_bet;
                        System.out.println("User_account: "+Money.format(User_account));
                    }
                } else {
                    System.out.println("Total = "+Total+"==>Over");
                    if(Select==1){
                        System.out.println("You win");
                        User_account = User_account + Amount_bet;
                        System.out.println("User_account: "+Money.format(User_account));
                    } else {
                        System.out.println("You lose");
                        User_account = User_account - Amount_bet;
                        System.out.println("User_account: "+Money.format(User_account));
                    }
                }
                if(User_account ==0 ){
                    System.out.println("Wish you luck next time");
                }
                System.out.println("");
            }
        }while(Option==1);
    }
}