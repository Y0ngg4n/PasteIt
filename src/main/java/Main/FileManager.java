package Main;

import java.io.*;

public class FileManager {

    private static final String currentFolder = new File("").getAbsolutePath();
    private static final String pastesFolder = "pastes/";

    public File createFile(String path) {
        System.out.println(currentFolder);
        System.out.println(path);
        return new File(currentFolder + "/" +  pastesFolder+ path);
    }

    public void createPasteFile(String path, String text) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(currentFolder + "/" +  pastesFolder+ path));
        bufferedWriter.write(text);
        bufferedWriter.close();
        System.out.println("Paste " + path + " created!");
    }

    public String getPasteText(String path) throws IOException{
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(currentFolder + "/" +  pastesFolder+ path));
            String text = "";
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                text += line;
            }
            System.out.println(text);
            return text;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        }
        return null;
    }

    public boolean pasteExists(String path) throws IOException{
        File file = new File(currentFolder + "/" +  pastesFolder+ path);
        return file.exists();
    }
}
