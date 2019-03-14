package Main;

import Language.LanguageDetector;
import Spring.Application;

public class Main {

    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        LanguageDetector.detect(fileManager.createFile("test.py"));
        Application.startSpring(args);
    }
}
