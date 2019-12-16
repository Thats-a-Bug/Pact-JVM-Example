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
            information.setNationality(Nationality.getNationality());
            information.setContact(contact);
            information.setName("SpongeBob SquarePants PhD");
            information.setSalary(45000);

        } else if (name.equals("Nanoha")) {
            HashMap contact = new HashMap<String, String>();
            contact.put("Email", "takamachi.nanoha@ariman.com");
            contact.put("Phone Number", "9090940");
            information.setSkills("Complex Quantum-Physis; Cooking; Philanthropy");
            information.setNationality(Nationality.getNationality());
            information.setContact(contact);
            information.setName("Takamachi Nanoha");
            information.setSalary(80000);

        } else {
            information.setSkills("Complex Quantum-Physis; Cooking; Philanthropy");
            information.setNationality(Nationality.getNationality());
            information.setContact(null);
            information.setName(name);
            information.setSalary(0);
        }

        return information;
    }
}
