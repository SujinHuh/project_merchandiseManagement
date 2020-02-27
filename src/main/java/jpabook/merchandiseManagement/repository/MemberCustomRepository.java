package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;

import java.util.List;

public interface MemberCustomRepository {

    List<Member> findByUserId(String userId);
    Member findOne(String userId);
   // Long save(Member member);
    List<Member> findByName(String name);
}
