package io.beneta.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board create(Board board) {
        return boardRepository.save(board);
    }

    public Page<Board> findByTitleContains(Pageable pageable, String keyword) {
        return boardRepository.findByTitleContains(pageable, keyword);
    }

    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    public Board update(Board board, Long id) {
        Board boardCatch = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류"));
        Board saveBoard = boardCatch.updateBoard(board, id);

        return Board.builder()
                .id(saveBoard.getId())
                .title(saveBoard.getTitle())
                .content(saveBoard.getContent())
                .writer((saveBoard.getWriter()))
                .build();
    }

    public Board delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류"));
        boardRepository.delete(board);
        return board;
    }
}
