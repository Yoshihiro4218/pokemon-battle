package jp.co.pokemon.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return ResponseEntity.ok("testOk!!");
    }
}
