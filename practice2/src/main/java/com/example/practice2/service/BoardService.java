package com.example.practice2.service;

import com.example.practice2.domain.entity.Board;
import com.example.practice2.domain.repository.BoardRepository;
import com.example.practice2.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

   @Transactional
    public List<BoardDto> getBoardList() {
       List<Board> boardList = boardRepository.findAll();
       List<BoardDto> boardDtoList = new ArrayList<>();

       for(Board board : boardList) {
           BoardDto boardDto = BoardDto.builder()
                   .id(board.getId())
                   .title(board.getTitle())
                   .author(board.getAuthor())
                   .createdDate(board.getCreatedDate())
                   .build();
           boardDtoList.add(boardDto);
       }
       return boardDtoList;
   }

   @Transactional
    public BoardDto getPost(Long id) {
       Board board = boardRepository.findById(id).get();

       BoardDto boardDto = BoardDto.builder()
               .id(board.getId())
               .title(board.getTitle())
               .author(board.getAuthor())
               .fileId(board.getFileId())
               .createdDate(board.getCreatedDate())
               .content(board.getContent())
               .build();
       return boardDto;
   }

   @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
   }
}
