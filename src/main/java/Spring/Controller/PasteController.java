package Spring.Controller;

import Main.Crypto;
import Main.FileManager;
import Spring.Controller.Objects.PasteObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PasteController {

    private static final FileManager fileManager = new FileManager();

    //TODO: Character Encoding to UTF-8
    //TODO: uuid is null
    @PostMapping(value = "/pastes/{fileid}", produces = "text/plain;charset=UTF-8")
    public String paste(@PathVariable("fileid") String fileid, Model model, @ModelAttribute(name = "pasteobject") PasteObject pasteobject) {
        System.out.println(pasteobject.getText());
        System.out.println("fileid: " + pasteobject.getUuid());
        final String key = getKey(pasteobject.getUuid());
        final String filename = getFilename(pasteobject.getUuid());
        System.out.println(pasteobject.getText());
        try {
            fileManager.createPasteFile(filename, Crypto.encryptBlowfish(pasteobject.getText(), key));
            System.out.println("Paste " + filename + " created!");
        } catch (Exception e) {
            System.out.println("Couldnt create Paste!");
            System.out.println(e.getMessage());
        }
        return "paste";
    }

    @GetMapping("/")
    public String pasteForm(Model model) {
        final PasteObject pasteObject = new PasteObject();
        String fileid = "";
        try {
            do {
                System.out.println("Generate FileID");
                fileid = generateID();
            } while (fileManager.pasteExists(getFilename(fileid)));
            pasteObject.setUuid(fileid);
        } catch (IOException e) {
            System.out.println("Couldn´t check if File exists");
        }
        System.out.println("Fieldasdsd id : " + fileid);
        System.out.println("Fisd id : " + pasteObject.getUuid());
        model.addAttribute("pasteobject", pasteObject);
        return "index";
    }

    @GetMapping(value = "/pastes/{fileid}")
    public String getPaste(@PathVariable("fileid") String fileid, Model model) {
        try {
            model.addAttribute("pasteobject", new PasteObject(Crypto.decryptBlowfish(fileManager.getPasteText(getFilename(fileid)), getKey(fileid)), getKey(fileid)));
        } catch (Exception e) {
            System.out.println("Couldnt decrypt!");
            System.out.println(e.getMessage());
        }
        System.out.println("Paste found!");
        return "paste";
    }

    //Fix for uuid is null, but maybe requires 2 different html for creation and for view
//    @ModelAttribute("pasteobject")
//    public PasteObject getPasteModelAttribute() {
//        final PasteObject pasteObject = new PasteObject();
//        String fileid = "";
//        try {
//            do {
//                System.out.println("Generate FileID");
//                fileid = generateID();
//            } while (fileManager.pasteExists(getFilename(fileid)));
//            pasteObject.setUuid(fileid);
//        } catch (IOException e) {
//            System.out.println("Couldn´t check if File exists");
//        }
//        return pasteObject;
//    }

    private String generateID() {
        return RandomStringUtils.randomAlphanumeric(15, 25);
    }

    private String getKey(String fileID){
        return fileID.substring(0, 10);
    }

    private String getFilename(String fileID){
        return fileID.substring(10);
    }
}
