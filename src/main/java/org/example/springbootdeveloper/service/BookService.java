package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.BookRequestDTO;
import org.example.springbootdeveloper.dto.request.BookRequestUpdateDTO;
import org.example.springbootdeveloper.dto.response.BookResponseDTO;
import org.example.springbootdeveloper.entity.Book;
import org.example.springbootdeveloper.entity.Category;
import org.example.springbootdeveloper.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    //책생성 (post)
    public BookResponseDTO createBook(BookRequestDTO requestDTO){
        Book book = new Book(//0-5인데
                null,requestDTO.getWriter(),requestDTO.getTitle(),requestDTO.getContent()
                ,requestDTO.getCategory()
        );
        Book savedBook =  bookRepository.save(book);
        return convertToResponseDto(savedBook);
    }

    public List<BookResponseDTO> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }
    //단건 책 조회
    public BookResponseDTO getBookById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을수 없습니다 "+id));
        return convertToResponseDto(book);
    }
    public List<BookResponseDTO> getBooksByTitleContaining(String keyword){
        List<Book> books = bookRepository.findByTitleContaining(keyword);   
        return books.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }
    public BookResponseDTO updateBook(Long id , BookRequestUpdateDTO updateDTO){
         Book book = bookRepository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("책을 찾을수 없습니다" +id));
         book.setTitle(updateDTO.getTitle());
         book.setContent(updateDTO.getContent());
         book.setCategory(updateDTO.getCategory());

         Book updatedBook = bookRepository.save(book);
         return convertToResponseDto(updatedBook);
    }
    public List<BookResponseDTO> getBooksByCategoryAndWriter(Category category ,String weiter){
        List<Book> books;
        if(category == null){
            books =bookRepository.findByWriter(weiter);
        }else{
            books = bookRepository.findByCategoryAndWriter(category, weiter);
        }
        return  books.stream()
                .map(this::convertToResponseDto )
                .collect(Collectors.toList());
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    private  BookResponseDTO convertToResponseDto(Book book){
        return new BookResponseDTO(
                book.getId(), book.getWriter(), book.getTitle(), book.getContent(),
                book.getCategory()
        );
    }

    public List<BookResponseDTO> getBooksByCategory(Category category) {
        return bookRepository.findByCategory(category)
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }
}

