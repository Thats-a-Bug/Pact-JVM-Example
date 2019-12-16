package ariman.pact.consumer;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public class Information {
    @Getter @Setter private String name;
    @Getter @Setter private String skills;
    @Getter @Setter private Map<String, String> contact = new HashMap<String, String>();
}
