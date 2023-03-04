import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FILE{
    File Folder;
    public FILE(String Path_Folder){
        Folder = new File(Path_Folder);
    }
    public FILE(){
    }
    public boolean Exists(){
        return this.Folder.exists();
    }
    public boolean Test_Run(){
        return this.Folder.canExecute();
    }
    public boolean Test_Read(){
        return this.Folder.canRead();
    }
    public boolean Test_Write(){
        return this.Folder.canWrite();
    }
    public void Print_Path(){
        System.out.println(this.Folder.getAbsolutePath());
    }
    public void Printf_Name(){
        System.out.println(this.Folder.getName());
    }
    public String Folder_Or_File(){
        if(this.Folder.isDirectory()){
            return "Folder";
        } else if(this.Folder.isFile()){
            return "File";
        } else {
            return "Other";
        }
    }
    public void Print_List(){
        if(this.Folder.isDirectory()){
            File[] Array = this.Folder.listFiles();
            for (File List : Array) {
                System.out.println(List.getAbsolutePath());
            }
        } else {
            System.out.println("File");
        }
    }
    public void Directory_List_Print(){
        this.Directory_List_Run(this.Folder,1);
    }
    public void Directory_List_Run(File Name,int Level){
        for(int i=0;i<Level;i++){
            System.out.print("\t");
        }
        System.out.print("<-->");
        System.out.println(Name.getName());
        if(Name.canRead()&&Name.isDirectory()){
            File[] Array = Name.listFiles();
            for(File List:Array){
                Directory_List_Run(List, Level +1);
            }
        }
    }
    public boolean Creat_Folder(File Creat_Folder){
        return Creat_Folder.mkdir();
    }
    public void Creat_File(File Creat_File){
            try {
                Creat_File.createNewFile();
                System.out.println("Đã tạo file: "+Creat_File.getAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
            }
    }
    public void Delete_Data(File Path){
        if(Path.isFile()){
            System.out.println("Đã xóa: "+Path.getAbsolutePath());
            Path.delete();
        } else if(Path.isDirectory()){
            File[] Arrays =Path.listFiles();
            for(File List : Arrays){
                Delete_Data(List);
            }
            System.out.println("Đã xóa: "+Path.getAbsolutePath());
            Path.delete();
        }
    }
    public boolean Rename(File Path_Initial,File Path_Rename){
        return Path_Initial.renameTo(Path_Rename);
    }
    public void Cut(File Path_Initial,File Path_Cut){
        try {
            Files.move(Path_Initial.toPath(), Path_Cut.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Đã di chuyển");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Copy(File Path_Initial,File Path_Copy){
        try {
            Files.copy(Path_Initial.toPath(), Path_Copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(Path_Initial.isDirectory()){
            File[] Arrays = Path_Initial.listFiles();
            for(File List : Arrays){
                File Path = new File(Path_Copy.getAbsolutePath()+"/"+List.getName());
                Copy(List, Path);
            }
        }
    }
    public void Write(File Path,String Text){
        try {
            PrintWriter Write_Text = new PrintWriter(Path);
            Write_Text.println(Text);
            Write_Text.flush();
            Write_Text.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Cách xuất dữ liệu văn bản ra màn hình(1)
    public void Read(File Path){
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
    /* Cách xuất dữ liệu văn bản ra màn hình(2)
    public void Read(File Path){
        try {
            List<String> Read_Text = Files.readAllLines(Path.toPath(), StandardCharsets.UTF_8);
            for(String Read : Read_Text){
                System.out.println(Read);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }*/
}