package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

  private final EntityManager entityManager;

    @Override
    public List<Member> findByUserId(String userId) {
        return entityManager.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();

    }

    @Override
    public Member findOne(String userId) {
        return (Member) entityManager.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();

        //.find(Member.class, userId);
    }

  //  @Override
//    public Long save(Member member) {
//        return null;
//    }

    @Override
    public List<Member> findByName(String name) {
        return entityManager.createQuery("select m from Member m where  m.name = :name", Member.class)
                .setParameter("name", name)
               .getResultList();
    }
}
