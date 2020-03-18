package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.controller.BoardFrom;
import jpabook.merchandiseManagement.domain.Board;
import jpabook.merchandiseManagement.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;

    /**
     * 수정, 삭제, 게시판 목록
     */

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElse(new Board());
    }

    //게시글 등록
    @Transactional
    public void registerBoard(Board board) {
        boardRepository.save(board);
    }

    //삭제
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}