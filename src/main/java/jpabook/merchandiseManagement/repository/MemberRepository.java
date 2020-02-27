package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.controller.MemberForm;
import jpabook.merchandiseManagement.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

//@Repository
//@RequiredArgsConstructor
public interface MemberRepository extends JpaRepository<Member ,Long>, MemberCustomRepository {

}

//
//    private final EntityManager entityManager;
//
//    public Long save(Member member) {
//        entityManager.persist(member);
//        return member.getId();
//    }
//
//    public Member findOne(String userid) {
//        return entityManager.find(Member.class, userid);
//    }
//
//         public List<Member> findAll() {
//        return entityManager.createQuery("select m from Member m", Member.class)
//                .getResultList();
//    }
//
//    public List<Member> findByName(String name) {
//
//        return entityManager.createQuery("select m from Member m where  m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//    Optional<Member> findByUserId(String userId);

//    findByName(String name);
//
//    List<Member> findOne(String userId);
//
//    Long save(Member member);
//
//    List<Member> findAll();


