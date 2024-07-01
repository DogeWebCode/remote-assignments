package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/thymeleaf")

public class ThymeleafController {

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String modelMap(String name, ModelMap map) {
        map.addAttribute("name", name);
        map.addAttribute("from", "com.jj");
        // 模版名稱，實際的目錄為：src/main/resources/templates/sum.html
        return "sum";
    }
}
