package io.beneta.board.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;
    
}
