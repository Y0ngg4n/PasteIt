package Spring.Controller;

import Spring.Controller.Objects.PasteObject;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PasteController {

    @PostMapping(value = "/pastes/{fileid}")
    public String greeting(@PathVariable("fileid") String fileid, Model model, @ModelAttribute(name = "pasteobject") PasteObject pasteobject) {
        return "paste" ;
    }

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("pasteobject", new PasteObject());
        return "index";
    }
}
