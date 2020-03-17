package jpabook.merchandiseManagement.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardFrom {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

//    @Builder
//    public BoardFrom(Long id,String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.createdDate = createdDate;
//        this.updatedDate = updatedDate;
//    }
}
