package com.example.chromedrivertesting.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    public String chrometstart() {
        return "chromeOn";
    }

//    Mapping ----------
    @GetMapping("/")
    public String home(@RequestParam(name="name", required=false, defaultValue="Сервер запустился") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/1")
    public String chromeStart (@RequestParam(name="name", required=false, defaultValue="Хром запустился") String name, Model model) {
        chrometstart();
        model.addAttribute("name", name);
        return "index";
    }


}