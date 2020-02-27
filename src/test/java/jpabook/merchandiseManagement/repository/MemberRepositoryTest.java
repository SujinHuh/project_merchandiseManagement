package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager entityManager;

    @Test
   // @Rollback(false)
    public void 회원가입() {

        Member member = new Member();
        member.setName("강님");
        member.setPosition("대");

       Long saveId = memberService.join(member);
        assertEquals(member,memberRepository.findOne(saveId));


//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.findOne(saveId);
//
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
//
//        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test(expected = AssertionError.class)
    public void 중복회원() throws Exception {
        //given
        Member memberOne = new Member();
        memberOne.setName("황사장");
        memberOne.setPosition("사장");

        Member memberTwo = new Member();
        memberTwo.setName("황사");
        memberTwo.setPosition("사장");

        memberService.join(memberOne);
        memberService.join(memberTwo);

        fail("예외 발생");

    }
}