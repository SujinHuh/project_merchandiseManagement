package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        List<Member> findMembers = memberRepository.findByName(member.getUserId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원이다.");
        }
    }

    //전체회원조회
    public List<Member> allMembers() {
        return memberRepository.findAll();
    }

    public Member findMember(String userId) {
       //memberRepository.findOne()
        return memberRepository.findOne(userId);
    }

    @Transactional
    public void update(String userId, String name) {
        Member member = (Member) memberRepository.findOne(userId);
        member.setName(name);
    }

    @Transactional
    public void saveMember(Member member) {
        memberRepository.save(member);
    }
}
