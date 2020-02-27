package jpabook.merchandiseManagement.service;

import jdk.nashorn.internal.codegen.MethodEmitter;
import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Transactional(readOnly = true)//읽기
@RequiredArgsConstructor //생성자 인젝션
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional//쓰기 readOnly = false
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원이다.");
        }
    }

    //전체회원조회
    public List<Member> AllMembers(Member member) {
        return memberRepository.findAll();
    }

    public Member findMember(Long membeId) {
        return memberRepository.findOne(membeId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
