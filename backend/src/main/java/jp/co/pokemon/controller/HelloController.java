package jp.co.pokemon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "hello")
@Slf4j
public class HelloController {

    @GetMapping
    public String greeting() {
        return "hello world";
    }

    @GetMapping(path = "{message}")
    public String greeting(@PathVariable(name = "message") String message) {
        return "hello " + message;
    }

    @PostMapping
    public String postGreeting(@RequestParam(name = "message") String message) {
        return "hello " + message;
    }

}