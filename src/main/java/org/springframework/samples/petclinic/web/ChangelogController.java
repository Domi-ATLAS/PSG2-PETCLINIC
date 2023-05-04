package org.springframework.samples.petclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangelogController {

    private static final String VIEWS_CHANGELOG = "changelog";

    @GetMapping("/changelog")
    public String changelog() {
        return VIEWS_CHANGELOG;
    }
    
}
