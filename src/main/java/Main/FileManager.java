package Main;

import java.io.File;

public class FileManager {

    private String currentFolder = new File("").getAbsolutePath();


    public File createFile(String path){
        System.out.println(currentFolder);
        System.out.println(path);
        return new File(currentFolder +  "/" +path);
    }
}
