package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.BoardDTO;
import org.example.springbootdeveloper.dto.StudentDto;
import org.example.springbootdeveloper.entity.Board;
import org.example.springbootdeveloper.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService =boardService;
    }
    @GetMapping
    public List<BoardDTO> getAllBoard(){
        return boardService.getAllBoard();
    }
    @GetMapping("/{id}")
    public BoardDTO getBoardById(@PathVariable Long id){
        return boardService.getBoardById(id);
    }
    @PostMapping
    public BoardDTO createBoard(@RequestBody BoardDTO boardDTO){
        return  boardService.createBoard(boardDTO);
    }

    public BoardDTO updateBoard(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
        return boardService.updateBoard(id,boardDTO);
    }

    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
               boardService.deleteBoard(id);
               return ResponseEntity.noContent().build();


    }
}
