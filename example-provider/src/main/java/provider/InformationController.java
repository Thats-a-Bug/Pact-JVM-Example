package provider;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import provider.ulti.Nationality;

@RestController
public class InformationController {

    private Information information = new Information();

    @RequestMapping("/information")
    public Information information(@RequestParam(value="name", defaultValue="Miku") String name) {
        if (name.equals("Miku")) {
            HashMap contact = new HashMap<String, String>();
            contact.put("Email", "spongebob@squarepants.com");
            contact.put("Phone Number", "9090950");
            information.setSkills("Complex Quantum-Physis; Cooking; Philanthropy");
            information.setContact(contact);
            information.setName("SpongeBob SquarePants PhD");

        } else if (name.equals("Nanoha")) {
            information.setAge("24");
            information.setRelatives("Harold SquarePants; Margaret SquarePants");
            information.setName("SpongeBob SquarePants");

        } else {
            information.setSkills("Complex Qusantum-Physis; Cooking; Philanthropy");
            information.setContact(null);
            information.setName(name);
        }

        return information;
    }
}
