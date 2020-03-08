package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {

    private final EntityManager entityManager;


    @Override
    public void memberSave(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member findMemberOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public List<Member> findMemberAll() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public List<Member> findByMemberEmail(String email) {
        return entityManager.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();

    }

    @Override
    public Optional<Member> findByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return Optional.empty();
    }
    //...
}
//    public void memberSave(jpabook.merchandiseManagement.domain.Member member) {
//        entityManager.persist(member);
//    }
//
//    public jpabook.merchandiseManagement.domain.Member findMemberOne(Long id) {
//        return entityManager.find(jpabook.merchandiseManagement.domain.Member.class, id);
//    }
//
//    public List<jpabook.merchandiseManagement.domain.Member> findAll() {
//        return entityManager.createQuery("select m from Member m", jpabook.merchandiseManagement.domain.Member.class)
//                .getResultList();
//
//    }
//
//    public List<jpabook.merchandiseManagement.domain.Member> findByEmail(String email) {
//        return entityManager.createQuery("select m from Member m where m.email = :email", Member.class)
//                .setParameter("email", email)
//                .getResultList();
//
//    }
