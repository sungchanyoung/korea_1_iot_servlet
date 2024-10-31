package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.common.constant.ResponseMessage;
import org.example.springbootdeveloper.dto.request.BookRequestDTO;
import org.example.springbootdeveloper.dto.request.BookRequestUpdateDTO;
import org.example.springbootdeveloper.dto.response.BookResponseDTO;
import org.example.springbootdeveloper.dto.response.ResponseDto;
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

    // 1. 게시글 생성(Post)
    public ResponseDto<BookResponseDTO> createBook(BookRequestDTO requestDto) {
        Book book = new Book(
                null, requestDto.getWriter(), requestDto.getTitle(),
                requestDto.getContent(), requestDto.getCategory()
        );

        Book savedBook = bookRepository.save(book);
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, convertToResponseDto(savedBook));
    }

    // 2. 전체 책 조회
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                // .map((book) -> convertToResponseDto(book))
                .collect(Collectors.toList());
    }

    // 3. 특정 ID 책 조회
    public BookResponseDTO getBookById(Long id) {
        try {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다: " + id));
            return convertToResponseDto(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BookResponseDTO();
        }
    }

    // 3-1. 제목에 특정 단어가 포함된 책 조회
    public List<BookResponseDTO> getBooksByTitleContaining(String keyword) {
        List<Book> books = bookRepository.findByTitleContaining(keyword);
        return books.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    // 3-2. 카테고리별 책 조회
    public List<BookResponseDTO> getBooksByCategory(Category category) {
        return bookRepository.findByCategory(category)
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    // 3-3. 카테고리 & 작성자별 책 조회
    public List<BookResponseDTO> getBooksByCategoryAndWriter(Category category, String writer) {
        List<Book> books;

        if (category == null) {
            books = bookRepository.findByWriter(writer);
        } else {
            books = bookRepository.findByCategoryAndWriter(category, writer);
        }

        return books.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    // 4, 특정 ID 책 수정
    public BookResponseDTO updateBook(Long id, BookRequestUpdateDTO updateDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다: " + id));

        book.setTitle(updateDto.getTitle());
        book.setContent(updateDto.getContent());
        book.setCategory(updateDto.getCategory());

        Book updatedBook = bookRepository.save(book);
        return convertToResponseDto(updatedBook);
    }

    // 5. 책 삭제
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Entity -> Response Dto 변환
    private BookResponseDTO convertToResponseDto(Book book) {
        return new BookResponseDTO(
                book.getId(), book.getWriter(), book.getTitle()
                , book.getContent(), book.getCategory()
        );
    }
}

