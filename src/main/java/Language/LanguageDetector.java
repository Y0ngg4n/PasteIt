package Language;

import Main.FileManager;

import java.io.*;
import java.util.logging.Logger;

public class LanguageDetector {

    private static final Logger logger = Logger.getLogger(FileManager.class.getName());

    public static void detect(File file){
        try {
            Process linguistProcess = Runtime.getRuntime().exec("github-linguist " + file.getAbsolutePath());

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(linguistProcess.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(linguistProcess.getErrorStream()));

            // read the output from the command
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                if(s.contains("language")){
                    String language = s.replace("language:  ", "");
                    System.out.println("Language found: " + language);
                }
                System.out.println(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println("Couldn´t detect Language:");
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Couldn´t detect Language");
        }
    }
}
