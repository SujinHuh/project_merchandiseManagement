package jpabook.merchandiseManagement.repository;
import jpabook.merchandiseManagement.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberCustomRepository {
    void memberSave(Member member);

    Member findMemberOne(Long id);

    List<Member> findMemberAll();

    List<Member> findByMemberEmail(String email);

    Optional<Member> findByEmail(String email);

}

