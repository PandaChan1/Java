package org.example;

import org.example.model.JSONResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("/test")
    public Object test() {
        return null;
    }

      @RequestMapping("/test2")
    public Object test2() {
          JSONResponse jsonResponse = null;
        return jsonResponse;
    }

}
