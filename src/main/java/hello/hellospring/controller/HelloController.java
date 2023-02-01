package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    // 1)템플릿엔진방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template"; //어디html로 리턴시킬지
    }

    // 2)API방식 //템플릿엔진을통해html을 내려주는것이 아니다.
    @GetMapping("hello-string")
    @ResponseBody //http 프로토콜의 헤더와 바디부분의 그 바디다. 바디부에 이 데이터를 직접 넣어주곘다.
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    // 3)API방식 //객체를 반환 JSON형태로
    @GetMapping("hello-api")
    @ResponseBody //HttpMessageConverter가 동작한다. return값이 객체면JSONConverter가 문자면 StringConverter가 동작
    //추가설명:@ResponseBody가 들어가면 ViewResorver 대신 HttpMessageConverter가 동작.
    public Hello helloAPI(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello; //리턴이 객체면 default로 JSON형태로 반환한다.
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name=name;
        }
    }
}
