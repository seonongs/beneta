package io.beneta.board;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;

    @CreatedDate
    private LocalDateTime created_date = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime modified_date = LocalDateTime.now();

    public Board updateBoard(Board board, Long id) {
        this.id = id;
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();

        return this;
    }

}
