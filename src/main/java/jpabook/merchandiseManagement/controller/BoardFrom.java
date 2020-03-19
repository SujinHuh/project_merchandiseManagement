package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardFrom {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
//
//    public Board toEntity() {
//        Board board = Board.builder()
//                .id(id)
//                .title(title)
//                .content(content)
//                .createdDate(createdDate)
//                .updatedDate(updatedDate)
//                .build();
//        return board;
//    }


    @Builder
    public BoardFrom(Long id,String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
