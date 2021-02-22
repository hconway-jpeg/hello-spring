package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Bye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloQueryParam(@RequestParam String name, @RequestParam String language, Model model) {
        String warmGreeting = HelloController.createMessage(name, language);
        model.addAttribute("greeting", warmGreeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    public static String createMessage(String name, String language) {
        if (language.contains("Chinese")) {
            return "Ni hao, " + name + "!";
        } else if (language.contains("Japanese")) {
            return "Konnichiwa, " + name + "!";
        } else if (language.contains("Hindi")) {
            return "Namaste, " + name + "!";
        } else if (language.contains("Italian")) {
            return "Ciao, " + name + "!";
        } else if (language.contains("Samoan")) {
            return "Talofa, " + name + "!";
        }
        return "Please choose a language in which to say 'Hello'";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
