package io.beneta.controller;

import io.beneta.board.Board;
import io.beneta.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public Board create(@RequestBody Board board) {
        return boardService.create(board);
    }
    @GetMapping
    public Page<Board> findByTitleContains(Pageable pageable, String keyword) {
        return boardService.findByTitleContains(pageable, keyword);
    }
    @GetMapping("/{id}")
    public Optional<Board> read(@PathVariable(value = "id") Long id) {
        return boardService.findById(id);
    }
    @PatchMapping("/{id}")
    public Board update(@PathVariable(value = "id")@RequestBody Board board, Long id) {
        return boardService.update(board, id);
    }
    @DeleteMapping("/{id}")
    public Board delete (@PathVariable(value = "id") Long id) {
        return boardService.delete(id);
    }

}
