package io.beneta.board.model;

import io.beneta.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;

    public Board updateBoard(Board board, Long id) {
        this.id = id;
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();

        return this;
    }

}
