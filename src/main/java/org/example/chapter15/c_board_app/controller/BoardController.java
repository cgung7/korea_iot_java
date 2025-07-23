package org.example.chapter15.c_board_app.controller;

import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;
import org.example.chapter15.c_board_app.repository.BoardRepository;
import org.example.chapter15.c_board_app.service.BoardService;
import org.example.chapter15.c_board_app.service.BoardServiceImpl;

import java.util.List;

public class BoardController {
    private final BoardService boardService;

    public BoardController() {
        this.boardService = new BoardServiceImpl();
    }

    // 1. 게시판 생성
    public void createBoard(BoardRequestDto dto) {
        if (isValidRequest(dto)) {
            // 게시글 등록 o
            boardService.createBoard(dto);
            System.out.println("게시글이 등록되었습니다.");
        } else {
            // 게시글 등록 X
            System.out.println("입력값이 유효하지 않습니다.");
        }
    }

    // 2. 게시판 조회 (전체)
    public List<BoardResponseDto> getAllBoards() {
        List<BoardResponseDto> boards = null;

        try {
            boards = boardService.findAllBoards();

            if(boards.isEmpty()) {
                throw new Exception("저장된 게시글이 없습니다.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return boards;

    }
    // 3. 게시판 조회 (단건)
    public BoardResponseDto getBoardById(Long id) {
        BoardResponseDto dto = null;

        try {
            dto = boardService.findBoardById(id);

            if (dto == null){
                throw new Exception("해당 id의 게시글이 존재하지 않습니다.");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;

    }

    // 4. 게시판 수정
    public void updateBoard(Long id, BoardRequestDto dto) {
        if (isValidRequest(dto)) {
            boardService.updateBoard(id, dto);
            System.out.println("게시글이 수정되었습니다.");
        } else {
            System.out.println("입력값이 유효하지 않습니다.");
        }
    }
    // 5. 게시판 삭제
    public void deleteBoard(Long id) {
        try{
            boardService.deleteBoard(id);
            System.out.println("게시글이 삭제되었습니다.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isValidRequest(BoardRequestDto dto) {
        String title = dto.getTitle();
        String content = dto.getContent();
        String author = dto.getAuthor();

        // &&: 하나라도 false명 false
        // >> title, content, author 모두 null 값이 아니고 비워져 있지 않음

        // 1) null: 아무런 값을 참조하지 않음 (주소값 X)
        // 2) isEmpty(): 비어 있는지 확인하는 메서드, 값(주소)는 존재하지만 그 내부 내용이 비어짐을 확인
        //              >> 문자열(""), 리스트([]), 배열([])
        boolean result = title != null && !title.isEmpty()
                && content != null && !content.isEmpty()
                && author != null && !author.isEmpty();

        return result;

    }



}
