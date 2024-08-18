package com.view.project.Entertainment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class Search {

    @Value("${youtube.api.key}")
    private String apiKey;

    private static final String YOUTUBE_API_URL = "https://www.googleapis.com/youtube/v3/search";

    public Map<String, Object> searchYouTube(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?part=snippet&q=%s&type=video&key=%s", YOUTUBE_API_URL, query, apiKey);

        // Make the request to YouTube Data API
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return response;
    }
}

