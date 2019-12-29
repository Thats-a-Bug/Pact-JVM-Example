package pact.consumer;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public class Information {
    @Getter @Setter private String fullName;
    @Getter @Setter private String skills;
    @Getter @Setter private Map<String, String> contact = new HashMap<String, String>();
}
