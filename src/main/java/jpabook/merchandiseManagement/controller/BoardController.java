package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Board;
import jpabook.merchandiseManagement.repository.BoardRepository;
import jpabook.merchandiseManagement.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /*
     * 게시글 목록
     */
    @GetMapping("/boardList")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "board/boardList";
    }

    /*
     * 게시글 상세 및 등록 폼 호출
     */
    @GetMapping("/boardForm/new")
    public String createFrom(Long id, Model model) {

        model.addAttribute("boardForm",new BoardFrom());
//        model.addAttribute("board", boardService.findBoardById(id));
        return "board/boardForm";
    }

    /*
     * 게시글 생성
     */
    @PostMapping("/boardForm/new")
    public ResponseEntity<?> create(@RequestBody BoardFrom boardFrom) {

       Board board = new Board();
       board.setTitle(boardFrom.getTitle());
       board.setContent(boardFrom.getContent());
       board.setCreatedDate(LocalDateTime.now());
       board.setUpdatedDate(LocalDateTime.now());

        boardService.registerBoard(board);

        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }


}
