package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}