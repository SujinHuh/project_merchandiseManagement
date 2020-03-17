package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/members/new")
    public String createFrom(Model model) {
        model.addAttribute("memberFrom", new MemberFrom());
        return "members/createMemberFrom";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberFrom form, BindingResult result) {

        if(result.hasErrors()) {
            return "members/createMemberFrom";
        }
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setName(form.getName());
        member.setPosition(form.getPosition());

        member.setPassword(passwordEncoder.encode(form.getPassword()));
        memberService.join(member);
        return "members/sinUpCongratulations";
    }

    @GetMapping("/members")
    public String memberList(Model model) {
        List<Member> members = memberService.memberList();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
