package org.springframework.samples.petclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportPageController {

    private static final String VIEWS_SUPPORT_PAGE = "supportPage";

    @GetMapping("/support")
    public String supportPage() {
        return VIEWS_SUPPORT_PAGE;
    }
    
}
