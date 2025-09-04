package org.example.jpastudent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class unicodeRestController {

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i){
        char c = (char)i;
        return "unicode= " + i + "char=" + c;
    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c){
        return "char= " + c + " unicode= " + (int) c;
    }
}
