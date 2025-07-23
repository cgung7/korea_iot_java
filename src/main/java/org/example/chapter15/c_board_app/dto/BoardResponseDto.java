package org.example.chapter15.c_board_app.dto;

import lombok.ToString;
import org.example.chapter15.c_board_app.entity.Board;

//BoardResponseDto
// : DB 게이판 데이터 중 사용자에게 응답으로 전달할 객체 구조
// - content 값을 제외한 필드를 제공
@ToString
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
        this.content = board.getContent();
    }

    public static BoardResponseDto fromEntity(Board board) {
        return new BoardResponseDto(board);
    }

}
