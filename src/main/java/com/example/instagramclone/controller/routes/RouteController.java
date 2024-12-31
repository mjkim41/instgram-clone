// controller/RouteController.java
package com.example.instagramclone.controller.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    // http://localhost/로 들어오면 index.jsp 열어라
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
