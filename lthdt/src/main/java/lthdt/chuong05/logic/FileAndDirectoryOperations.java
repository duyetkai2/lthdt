    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong05.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class FileAndDirectoryOperations {

    public FileAndDirectoryOperations() {
    }
    public File[] getDirectoryContent(String folder){
        File directory = new File(folder);
        if(directory.isFile())
            return null;
        File[] results = directory.listFiles();
        return results;
        
    }
    public String displayContent(File[] content){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<content.length;i++){
            sb.append(content[i].getPath()).append(File.separator).append(content[i].getName());
            sb.append("\n");
        }
        return sb.toString();
    }
    //thao tác 3: lọc ra các thư mục
    public File[] getSubDirectories(File[] content){
        ArrayList<File> result = new ArrayList<>();
        for(int i = 0; i < content.length; i++){
                if(content[i].isDirectory()){
                    result.add(content[i]);
                }
        }
        File[] ketqua = new File[result.size()];
        return result.toArray(ketqua);
    
}
    //thao tac 4: loc ra tat ca cac tap tin
    public File[] getFiles(File[] content){
         ArrayList<File> result = new ArrayList<>();
        for(int i = 0; i < content.length; i++){
                if(content[i].isFile()){
                    result.add(content[i]);
                }
        }
        File[] ketqua = new File[result.size()];
        return result.toArray(ketqua);
    

    }
    //thao tac 5: duyet de quy xuat tat ca cac tap tin va thu muc
    public void getContentRecursively(String folder){
        File content = new File(folder);
//        content.delete();
        //dieukiendung
        if(content.isFile()){
            System.out.println(content.getPath() + File.separator + content.getName());
            return;
            
        }
        System.out.println("thu muc: " + folder);
        File[] sub = content.listFiles();
        for(int i = 0; i < sub.length; i++){
            getContentRecursively(folder + File.separator + sub[i].getName());
        }
    }
    //thao tac6: doc file van ban
    public String readTextFile(String filename ){
        StringBuilder content = new StringBuilder();
        try {
            //mo file
            FileReader fr = new FileReader(filename);
            //dung bo dem
            BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line = br.readLine()) != null){
             content.append(line);
             content.append("\n");
        }
        //dong file
        br.close();
        fr.close();
        } catch (FileNotFoundException ex) {
         return "Khong tim thay file " + filename;
        } catch (IOException ex) {
          return "Khong the doc file " + filename;
        }
       return content.toString();
}
    public boolean writeTextFile(String filename, String content){
        boolean flag = true;
        try {
            //mo file
            FileWriter fw = new FileWriter(filename);
            //su dung buffer
             BufferedWriter bw = new BufferedWriter(fw);
             //ghi ra file
             bw.write(content);
             //dong file
             bw.flush();
             bw.close();
             fw.close();
        } catch (IOException ex) {
           return false;
        }
        return flag;
    }
}