package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //로컬호스트 8080에 첫 진입할때 return값인 home.html 이 호출된다.
    public String home() {
        return "home";
    }
}
