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
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    /*
     * 게시글 목록
     */
    @GetMapping("/boardList")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "board/boardList";
    }

//    /*
//     * 게시글 상세 및 등록 폼 호출
//     */
//    @GetMapping({"","/","/boardForm/new"})
//    public String board(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
//        model.addAttribute("board", boardService.findBoardById(id));
//        return "board/boardForm";
//    }

    /*
     * 게시글 생성
     */
//    @PostMapping("/boardForm/new")
//    public String create(@RequestBody Board board) {
//
////       Board board = new Board();
////       board.setTitle(boardFrom.getTitle());
////       board.setContent(boardFrom.getContent());
////       board.setCreatedDate(LocalDateTime.now());
////       board.setUpdatedDate(LocalDateTime.now());
//
//        board.setId(board.getId());
//        board.setTitle(board.getTitle());
//        board.setContent(board.getContent());
//        board.setCreatedDate(LocalDateTime.now());
//        board.setUpdatedDate(LocalDateTime.now());
//
//        boardService.registerBoard(board);
//
//        return "redirect:/broad/broadList";
//        return new ResponseEntity<>("{}", HttpStatus.CREATED);
//    }
    /*
     * 게시글 수정
     */
//    @PutMapping("/{id}")
//    public ResponseEntity<?> putBoard(@PathVariable("id") Long id, @RequestBody Board board) {
//        Board updateBoard = boardService.findBoardById(id);
//        updateBoard.setTitle(board.getTitle());
//        updateBoard.setContent(board.getContent());
//        updateBoard.setUpdatedDate(LocalDateTime.now());
//
//        boardService.registerBoard(updateBoard);
//
//        return new ResponseEntity<>("{}", HttpStatus.OK);
//    }

    /*
     * 게시글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }



    @GetMapping("/boardForm/new")
    public String write() {
        return "board/write";
    }

    @PostMapping("/boardForm/new")
    public String write(BoardFrom form) {
        boardService.saveBoard(form);
        return "redirect:/";
    }
}
