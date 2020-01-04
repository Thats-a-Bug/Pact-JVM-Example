package pact.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformationController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/linkedin")
    public String linkedin(Model model) {
        Information information = providerService.getInformation();
        model.addAttribute("skills", information.getSkills());
        model.addAttribute("name", information.getName() + " " + information.getCredentials());
        model.addAttribute("email", information.getContact().get("email"));
        model.addAttribute("phone", information.getContact().get("phone"));

        return "linkedin";
    }

}
