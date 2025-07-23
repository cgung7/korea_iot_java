package org.example.chapter15.c_board_app.service;

import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;
import org.example.chapter15.c_board_app.entity.Board;
import org.example.chapter15.c_board_app.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardServiceImpl implements BoardService{
    private final BoardRepository repository;

    // 생성자 주입
    public BoardServiceImpl() {
        this.repository = new BoardRepository();
    }

    @Override
    public void createBoard(BoardRequestDto dto) {
        // dto 객체에서 인스턴스 메서드 호출
        Board board = dto.toEntity();
        repository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        if (!repository.findById(id).isPresent()) {
            // 해당 id의 데이터가 존지하지 X
            throw new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다.");
        }
        repository.delete(id);

    }

    @Override
    public List<BoardResponseDto> findAllBoards() {
        List<Board> boardList = repository.findAll();

        // 게시판 데이터를 응답 객체로 변환
        List<BoardResponseDto> boardResponseDtos = boardList.stream()
//                .map(board -> BoardResponseDto.fromEntity(board))
                .map(BoardResponseDto::fromEntity)
                .collect(Collectors.toList());

        return boardResponseDtos;
    }

    @Override
    public BoardResponseDto findBoardById(Long id) {
        Optional<Board> board = repository.findById(id);

        // Optional<Board> >> Optional<BoardResponceDto> 변환
        // : 변환 작업을 할 때
        BoardResponseDto boardResponseDto = board.map(BoardResponseDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다."));

        return boardResponseDto;
    }

    @Override
    public void updateBoard(Long id, BoardRequestDto dto) {
        Board existingBoard = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다"));

        existingBoard.setTitle(dto.getTitle());
        existingBoard.setContent(dto.getContent());

    }
}
