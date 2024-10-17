package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.BookRequestDTO;
import org.example.springbootdeveloper.dto.request.BookRequestUpdateDTO;
import org.example.springbootdeveloper.dto.response.BookResponseDTO;
import org.example.springbootdeveloper.entity.Category;
import org.example.springbootdeveloper.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
//초기화  되지 않은 final 필드나 @NonNull이 붙은 필드에 대해 생성자를 생성
public class BookController {
    //의존성 주입
    private  final BookService bookService ;


    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO requestDTO){
        BookResponseDTO createBook = bookService.createBook(requestDTO);
        return ResponseEntity.ok(createBook);// 성공시 책 도 반환

    }

//    전체 책 조회
    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    //제목에 특정 단어가  포함  단어 게시글 조회


    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getById(@PathVariable Long id){
        BookResponseDTO book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
    @GetMapping("/search/title")
    public  ResponseEntity<List<BookResponseDTO>>getBooksByTitleContaining(
            @RequestParam String keyword){
        List<BookResponseDTO> books  = bookService.getBooksByTitleContaining(keyword);
        return ResponseEntity.ok(books);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookResponseDTO>> getBooksByCategory(@PathVariable Category category){
        List<BookResponseDTO> books  =bookService.getBooksByCategory(category);
        return  ResponseEntity.ok(books);
    }
    @GetMapping("/search/category-writer")
    public ResponseEntity<List<BookResponseDTO>> getBooksByCategoryAndWriter(
            @RequestParam(required = false) Category category,
            @RequestParam String writer
    ){
        List<BookResponseDTO> books = bookService.getBooksByCategoryAndWriter(category,writer);
            return ResponseEntity.ok(books);


    }

//    //책 수정
    @PutMapping("/{id}")
    public  ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id,
                                                        @RequestBody BookRequestUpdateDTO requestDRO){
        BookResponseDTO updatedBook =bookService.updateBook(id,requestDRO);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
