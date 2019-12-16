package provider;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public class Information {
    @Getter @Setter private String name;
    @Getter @Setter private String skills;
    @Getter @Setter private Map<String, String> contact = new HashMap<String, String>();
    @Getter @Setter private String age;
    @Getter @Setter private String relatives;

}
