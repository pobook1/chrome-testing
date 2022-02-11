package com.example.chromedrivertesting.servingwebcontent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    public String chrometstart() {
        System.setProperty("webdriver.chrome.driver", "/app/.chromedriver/bin/chromedriver");
        ChromeOptions choptions = new ChromeOptions();
        choptions.setBinary(System.getenv("GOOGLE_CHROME_SHIM"));
        choptions.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver(choptions);
        webDriver.get("http://pitomnikrazina.ru/");
        String title = webDriver.getTitle();
        webDriver.quit();
        return title;
    }

//    Mapping ----------
    @GetMapping("/")
    public String home(@RequestParam(name="name", required=false, defaultValue="Сервер запустился") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/1")
    public String chromeStart (@RequestParam(name="name", required=false, defaultValue="Хром запустился!") String name, Model model) {
        model.addAttribute("name", chrometstart());
        return "index";
    }


}