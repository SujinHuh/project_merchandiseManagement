package jpabook.merchandiseManagement.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter

@NoArgsConstructor
@Entity
public class Board {

    @Id @Column(name = "board_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    @Type(type = "text")
    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @Builder
    public Board(Long id, String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
