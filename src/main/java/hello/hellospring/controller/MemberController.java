package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링컨테이너에서 가져온다. DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new") // (1) 이 url을 입력하면
    public String createForm() {
        return "members/createMemberForm"; //(2) 이 위치의 html로 이동한다.
    }

    @PostMapping("/members/new") //데이터를 폼에 넣어 post방식으로 보냈다. <form action="/members/new" method="post">
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}
