package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
