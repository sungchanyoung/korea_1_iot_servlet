package org.example.springbootdeveloper.service;

import org.example.springbootdeveloper.dto.BoardDTO;
import org.example.springbootdeveloper.dto.StudentDto;
import org.example.springbootdeveloper.entity.Board;
import org.example.springbootdeveloper.repository.BoardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Service
public class BoardService {
    private final BoardRepository boardRepository;


    public  BoardService (BoardRepository boardRepository){
        this.boardRepository =boardRepository;
    }
    //생성자 주입
    //모든 계시판 목록 가져오기
    public List<BoardDTO> getAllBoard() {
        try {
            List<Board> boards = boardRepository.findAll();
            List<BoardDTO> boardsDto = boards.stream()
                    .map(board -> new BoardDTO(
                            board.getId(),
                            board.getWriter(),
                            board.getTitle(),
                            board.getContent(),
                            board.getCategory()
                    ))
                    .collect(Collectors.toList());
            return boardsDto;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while fetching Board", e
            );
        }
}
        public BoardDTO getBoardById(Long id) {
            try {
                Board board = boardRepository.findById(id)
                        .orElseThrow(() -> new Error("Board not found :" + id));
                BoardDTO boardDTO= new BoardDTO(
                        board.getId(),
                        board.getWriter(),
                        board.getTitle(),
                        board.getContent(),
                        board.getCategory()
                );
                return boardDTO;
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Error occurred while fetching Board", e
                );
            }
        }
        public BoardDTO createBoard (BoardDTO boardDTO) {
            try {
                Board board = new Board(boardDTO.getTitle(), boardDTO.getWriter(), boardDTO.getContent(), boardDTO.getCategory());
                Board saveBoard = boardRepository.save(board);
                return  new BoardDTO(saveBoard.getId()
                        ,saveBoard.getTitle()
                        ,saveBoard.getWriter()
                ,saveBoard.getContent()
                ,saveBoard.getCategory());
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Failed to create student",e
                );
            }

        }
        public  BoardDTO updateBoard(Long id, BoardDTO boardDTO){
            try{
                Board board = boardRepository.findById(id)
                        .orElseThrow(() -> new Error("Board not found with id "+ id));
                board.setTitle(board.getTitle());
                board.setWriter(board.getWriter());
                board.setContent(board.getContent());
                board.setCategory(board.getCategory());
                Board updateBoard =  boardRepository.save(board);
                return  new BoardDTO(updateBoard.getId(),
                        updateBoard.getTitle()
                        , updateBoard.getWriter()
                       , updateBoard.getContent(),
                        updateBoard.getCategory());
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Error occurred while updating student"
                ,e);
            }
        }
        public  void deleteBoard(Long id){
            try{
                Board board=boardRepository.findById(id)
                        .orElseThrow(() -> new Error("Board not found with id"));
                boardRepository.delete(board);//board ->id
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Error occurred while updating student",e);
            }
        }
    }


