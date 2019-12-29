package provider;

import java.util.HashMap;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
public class InformationController {

    @RequestMapping("/information")
    public Information information(@RequestParam(value="name", defaultValue="linkedin") String name) {
        if ("facebook".equals(name))
        {
            return getFacebookData();
        }
        return getLinkedInData();
    }


    private Information getFacebookData()
    {
        Information information = new Information();
        information.setAge("24");
        information.setRelatives("Harold SquarePants; Margaret SquarePants");
        information.setFullName("SpongeBob SquarePants");
        information.setCity("Bikini Valley");
        return information;
    }


    private Information getLinkedInData()
    {
        Information information = new Information();
        Map<String, String> contact = new HashMap<>();
        contact.put("email", "spongebob@squarepants.com");
        information.setSkills("Complex Quantum Mechanics; Cooking; Philanthropy");
        information.setContact(contact);
        information.setFullName("SpongeBob SquarePants PhD");
        return information;
    }
}
