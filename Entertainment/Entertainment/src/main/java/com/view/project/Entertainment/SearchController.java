package com.view.project.Entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private Search searchService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public Map<String, Object> search(@RequestParam String query) {
        return searchService.searchYouTube(query);
    }
}
