package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.memory.MemRegion;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    /**
     * 1. 회원가입 - MemberJoin
     * 2. 회원 목록 - MemberList (전체 회원 조회)
     * 3. 회원 한명 조회 - MemberFindOne
     * 4. 회원 존재 유뮤 - validateDuplicateMember
     * 5. 회원 수정
     */

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 회원 목록
    public List<Member> memberList(Member member) {
        return memberRepository.findAll();
    }

    // 회원 한명 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

    // 회원 존재 유뮤
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
