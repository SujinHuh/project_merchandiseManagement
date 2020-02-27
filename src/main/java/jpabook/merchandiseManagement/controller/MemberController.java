package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.repository.MemberRepository;
import jpabook.merchandiseManagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

//    @GetMapping("/main")
//    public String mainPage(Model model) {
//        List<Member> members = memberService.allMembers();
//        model.addAttribute("members", members);
//        return "home";
//    }

    @GetMapping("/main")
    public String mainPage(@AuthenticationPrincipal User user,
                           Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        model.put("currentMemberId", user.getUsername());
        return "homepage";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        return "admin";
    }

    @GetMapping("/members/new")
    public String memberJoinForm(Model model) {
        model.addAttribute("memberJoinForm", new MemberForm());
        return "members/memberJoinForm";
    }

    @PostMapping("/members/new")
    public String memberJoin(@Valid MemberForm memberForm, BindingResult result) {

        if (result.hasErrors()) {
            return "memberJoinForm";
        }
        Member member = new Member();
        member.setUserId(memberForm.getUserId());
        member.setName(memberForm.getName());
        member.setPassword(memberForm.getPassword());

        member.setPosition(memberForm.getPosition());
        memberService.join(member);

        memberForm.setPassword(passwordEncoder.encode(memberForm.getPassword()));
        memberService.saveMember(member);
//        memberRepository.save(memberForm);
        return "redirect:/login";
    }

//    @PostMapping("/members/new")
//    public String memberJoin(Member memberForm) {
//        /* PasswordEncoder로 비밀번호 암호화 */
//        memberForm.setPassword(passwordEncoder.encode(memberForm.getPassword()));
//        memberRepository.save(memberForm);
//        return "redirect:/login";
//    }
//    @GetMapping("/members/new")
//    public String memberJoinForm(@Valid MemberForm form, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "memberJoinForm";
//        }
//        Member member = new Member();
//        member.setName(form.getName());
//        member.setPassword(form.getPassword());
//        member.setPosition(form.getPosition());
//
//        memberService.join(member);
//        return "redirect:/";
//    }
//
//    @PostMapping("/members/new")
//    public String memberJoin(Member member) {
//        memberService.saveMember(member);
//        return "redirect:/login";
//    }
}

