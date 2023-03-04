import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class SET {
    Set<String> List_MSSV = new HashSet<String>();
    //Thay HashSet = TreeSet kiểu dữ liệu đc sắp xếp theo thứ tự(nhớ import.java.util.TreeSet);
    public SET(){}
    public boolean Add(String MSSV){
        return this.List_MSSV.add(MSSV);
    }
    public boolean Delete(String MSSV){
        return this.List_MSSV.remove(MSSV);
    }
    public boolean Check(String MSSV){
        return this.List_MSSV.contains(MSSV);
    }
    public void Clear(){
        this.List_MSSV.clear();
    }
    public int Size(){
        return this.List_MSSV.size();
    }
    public String MSMM(){
        Random Random = new Random();
        int Loca = Random.nextInt(this.List_MSSV.size());
        String Resuft = (String)this.List_MSSV.toArray()[Loca];
        return Resuft;
    }
    public void Print(){
        System.out.println(Arrays.toString(this.List_MSSV.toArray()));
    }
}