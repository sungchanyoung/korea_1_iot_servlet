package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.CommentRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Comment;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.CommentRepository;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    private  final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public ResponseDto<CommentResponseDto> createComment(CommentRequestDto dto) {
        try{//변환 시켜줘야한다하는데  Long 형식을  ->객체 형식으로 반환하는 방법
            Post post = postRepository.findById(dto.getPostId()).orElseThrow(()
                    ->new IllegalArgumentException("retry"));
            Comment comment = Comment.builder()
                    .post(post)
                    .content(dto.getContent())
                    .commenter(dto.getCommenter())
                    .build();
            commentRepository.save(comment);
            return ResponseDto.setSuccess("댓글이 정상적으로 등록되었습니다.",convertToCommentResponseDto(comment));
        } catch (Exception e) {
            return ResponseDto.setFailed("댓글 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public ResponseDto<List<CommentResponseDto>> getCommentByPost(Long postId) {
        List<CommentResponseDto> comment =
        return null;

    }

    public ResponseDto<CommentResponseDto> updateComment(Long commentId,String newContent) {
        return null;

    }

    public ResponseDto<Void> deleteComment(Long commentId) {
        try{
            Post post  =postRepository.findById(commentId)
                    .orElseThrow(() -> new Error("Post not found"));
            postRepository.delete(post);
            //일반적으로 성공 했는지 에 대한 유무를 리턴하고
            return ResponseDto.setSuccess("success", null);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while updating psot",e);
        }
    }
    private CommentResponseDto convertToCommentResponseDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(), comment.getPost().getId(), comment.getContent()
                , comment.getCommenter()
        );
    }
}
