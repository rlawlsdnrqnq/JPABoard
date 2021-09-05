package com.example.practice2.dto;

import com.example.practice2.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Long fileId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .title(title)
                .author(author)
                .content(content)
                .fileId(fileId)
                .build();
        return build;
    }
    
    @Builder
    public BoardDto(Long id, String title, String author, String content, Long fileId, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.fileId = fileId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
