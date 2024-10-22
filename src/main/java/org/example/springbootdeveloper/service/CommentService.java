package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.CommentRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Comment;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.CommentRepository;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


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
        try {
            //주어진 postId를 기준으로 모든 댓글을 찾는 메서드
            List<CommentResponseDto> comment= commentRepository.findByPostId(postId)
                    .stream()
                    .map(this::convertToCommentResponseDto)
                    .collect(Collectors.toList());
            return ResponseDto.setSuccess("댓글을 정상적으로 가져왔습니다.",comment);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while updating comment"
                    ,e);
        }
    }
        //newContent를 사용해서를 사용해서 업데이트된 댓글 내용을 설정해야해
        //comment.getContent는  기존의 내용이기 때문에 새로운 내용을 반영하려면 newContent를 사용함
        //새로운 댓글이 저장될것이고 반환
    public ResponseDto<CommentResponseDto> updateComment(Long commentId,String newContent) {
       try {
           Comment comment = commentRepository.findById(commentId)
                   .orElseThrow(() -> new IllegalArgumentException("try again"));
            comment.setContent(newContent);
           commentRepository.save(comment);
           return  ResponseDto.setSuccess("success",convertToCommentResponseDto(comment));
       } catch (Exception e) {
           throw new ResponseStatusException(
                   HttpStatus.INTERNAL_SERVER_ERROR,
                   "Error occurred while updating comment"
                   ,e);
       }

    }
    //Id를 이용해서 삭제 VS 객체를 이용해서 객체를 이용해서 삭제
    //차이점 : ID로 직접 삭제하면 더 간단하게 삭제 가능 ,객체러 삭제하면 더 명확하게 삭제 가능
    public ResponseDto<Void> deleteComment(Long commentId) {
        try{
            //댓글 삭제하기떄문에 commentId로 해당 댓글을 조회해서 댓글 삭제
              Comment comment = commentRepository.findById(commentId)
                      .orElseThrow(() ->  new IllegalArgumentException("retry "));
              commentRepository.delete(comment);
              return ResponseDto.setSuccess("success",null);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while deleteing comment",e);
        }
    }
    //Comment를 객체로 받아서  -> CommentResoponseDto타입 의 객체로 변환
    // CommentDto에 있는 필등의 고유값들을 반환시킴
    private CommentResponseDto convertToCommentResponseDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(), comment.getPost().getId(), comment.getContent()
                , comment.getCommenter()
        );
    }
}
