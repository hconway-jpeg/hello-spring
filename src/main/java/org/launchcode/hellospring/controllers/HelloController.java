package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Bye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloQueryParam(@RequestParam String name, @RequestParam String language) {
        String warmGreeting = HelloController.createMessage(name, language);
        return warmGreeting;
    }

    @GetMapping("hello/{name}")
    public String helloPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return
            "<html>" +
                "<body>" +
                    "<form action='hello' method='post'>" +
                        "<input type='text' name='name'/>" +
                            "<select name='language'> " +
                                "<option value=''> ~~ Languages ~~ </option>" +
                                "<option value='Chinese'>Chinese</option>" +
                                "<option value='Japanese'>Japanese</option>" +
                                "<option value='Hindi'>Hindi</option>" +
                                "<option value='Italian'>Italian</option>" +
                                "<option value='Samoan'>Samoan</option>" +
                            "</select>" +
                        "<input type='submit' value='Greet me!'/>" +
                    "</form>" +
                "</body>" +
            "</html>";
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

}
