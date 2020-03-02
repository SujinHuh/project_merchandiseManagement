package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.Member;

import jpabook.merchandiseManagement.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    /**
     * 1. 회원 가입에 성공
     * 2. 회원가입시 같은 이름과, 이메일이 있다면 예외발생
     */
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;


    @Test //회원 가입에 성
    public void joinOk() throws Exception {

        //given
        Member member = new Member();
        member.setName("수진");
        member.setEmail("sujin@nam");
        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

//    private Member createMember() {
//        Member member = new Member();
//        member.setEmail("sujin@m");
//        member.setPassword("pass");
//        member.setPosition("사장");
//        member.setName("내가 사장이다.");
//
//        return member;
//    }
    @Test (expected = IllegalStateException.class)
    //회원 가입 중복확인
    public void duplicateJoinFail() throws Exception {
        //given
        Member member = new Member();
        member.setName("수진");
        member.setEmail("sujin@nam");
        memberService.join(member);

        Member memberOne = new Member();
        memberOne.setName("수진");
        memberOne.setEmail("sujin@nam");
        memberService.join(memberOne);

        //when
      fail("예외발");
        //then

    }

}