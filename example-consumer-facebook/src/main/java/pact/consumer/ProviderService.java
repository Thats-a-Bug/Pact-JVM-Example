package pact.consumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProviderService {

    private String backendURL = "http://localhost:8080/information?name=facebook";

    public Information getInformation() {
        return new RestTemplate().getForObject(backendURL, Information.class);
    }
}
