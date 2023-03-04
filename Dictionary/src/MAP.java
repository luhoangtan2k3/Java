import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MAP {
    public MAP(){};
    Map<String,String> Dictionary = new TreeMap<String,String>();

    public String Add(String Key,String Vocabulary){
        return this.Dictionary.put(Key, Vocabulary);
    }
    public String Delete(String Key){
        return this.Dictionary.remove(Key);
    }
    public String Look_up_dictionary(String Key){
        return this.Dictionary.get(Key);
    }
    public void Printf(){
        Set<String> List = this.Dictionary.keySet();
        System.out.println(Arrays.toString(List.toArray()));
    }
    public int Size(){
        return this.Dictionary.size();
    }
    public void Clear(){
        this.Dictionary.clear();
    }
}