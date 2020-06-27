package provider;

import java.util.HashMap;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
public class InformationController {

    @RequestMapping("/information")
    public Information information(@RequestParam(value="name", defaultValue="linkedin") String name) {
        return getSpongeBobData();
    }

    private Information getSpongeBobData()
    {
        Information information = new Information();
        Map<String, String> contact = new HashMap<>();
        contact.put("email", "spongebob@squarepants.com");
        contact.put("phone", "9090950");
        information.setSkills("Complex Quantum Mechanics; Cooking; Philanthropy");
        information.setContact(contact);
        information.setName("SpongeBob SquarePants");
        information.setCredentials("PhD");
        information.setAge("24");
        information.setRelatives("Harold SquarePants; Margaret SquarePants");
        return information;
    }
}
