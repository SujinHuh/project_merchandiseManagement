package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Page<Board> findBoardList(Pageable pageable);

    Board findBoardByIdx(Long id);
}
