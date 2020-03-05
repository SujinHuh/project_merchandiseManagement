package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

//@Repository
//@RequiredArgsConstructor
public interface MemberRepository extends JpaRepository<Member,Long>, MemberCustomRepository {
}
//    /**
//     * save findOne findAll findByEmail
//     */
//
//    private final EntityManager entityManager;
//
//    public void save(Member member) {
//        entityManager.persist(member);
//    }
//
//    public Member findOne(Long id) {
//        return entityManager.find(Member.class, id);
//    }
//
//    public List<Member> findAll() {
//        return entityManager.createQuery("select m from Member m", Member.class)
//                .getResultList();
//
//    }
//
//    public List<Member> findByEmail(String email) {
//        return entityManager.createQuery("select m from Member m where m.email = :email", Member.class)
//                .setParameter("email",email)
//                .getResultList();
//
//    }
