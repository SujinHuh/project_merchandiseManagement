package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Board;
import jpabook.merchandiseManagement.repository.BoardRepository;
import jpabook.merchandiseManagement.service.BoardService;
import lombok.RequiredArgsConstructor;
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
    private final BoardRepository boardRepository;


    /*
     * 게시글 목록
     */
    @GetMapping("/list")

    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "board/list";
    }

    /*
     * 게시글 상세 및 등록 폼 호출
     */
    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(id));
        return "board/form";
    }

    /*
     * 게시글 생성
     */
    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody Board board) {
        board.setCreatedDate(LocalDateTime.now());
        board.setUpdatedDate(LocalDateTime.now());
        boardRepository.save(board);

        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    /*
     * 게시글 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putBoard(@PathVariable("id") Long idx, @RequestBody Board board) {
        Board updateBoard = boardRepository.getOne(idx);
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContent(board.getContent());
        updateBoard.setUpdatedDate(LocalDateTime.now());
        boardRepository.save(updateBoard);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /*
     * 게시글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardRepository.deleteById(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
