package com.target.notifier.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutesConfig {

    @RequestMapping("/")
    public String swaggerIndex() {
        return "redirect:/swagger-ui.html";
    }
}
