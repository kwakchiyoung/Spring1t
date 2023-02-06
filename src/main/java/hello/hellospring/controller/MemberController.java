package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 컨테이너에서 맴버컨트롤러를 관리한다. 스프링 빈이 관리된다. 라고 한다.
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { //생성자 단축키 맥os는 커맨드+N
        this.memberService = memberService;
    }
}
