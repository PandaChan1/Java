package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restTest")
public class TestRestController {
    @GetMapping("/1")
    public String test() {
        return "66666";
    }
}
