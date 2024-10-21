package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.PostRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//전달받는 요청 ,반환하는 응답
public class PostService {
    private final PostRepository postRepository;

    public ResponseDto<PostResponseDto> createPost(PostRequestDto dto) {
        try {//응답은 다섯개의 필드가 필요하다
            Post post = Post.builder()
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .author(dto.getAuthor())
                    .build();
            postRepository.save(post);
            return ResponseDto.setSuccess("게시글이 정상적으로 등록되었습니다.",convertToCommentResponseDto(post));
        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 등록 중 오류가 발생했습니다: " + e.getMessage());
        }

    }

    public ResponseDto<PostResponseDto> getPostById(Long postId) {
        try {
                Post post = postRepository.findById(postId)
                        .orElseThrow(() -> new IllegalArgumentException("Post no found with id"+postId)) ;
                return ResponseDto.setSuccess("게시글이 하나 조회되었습니다.",convertToCommentResponseDto(post));
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Error occurred while updating student"
                        ,e);
            }
    }
    //갯수가 많은 것들은 List
    public ResponseDto<List<PostResponseDto>> getAllPost() {
        try{//ResponseDto타입 변수를 설정 해야한다
            List<PostResponseDto>  post= postRepository.findAll()
                    .stream()
                    .map(this::convertToCommentResponseDto)
                    .collect(Collectors.toList());
            return ResponseDto.setSuccess("게시글을 정상적으로 가져왔습니다.",post);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while updating student"
                    ,e);
        }

    }

    public ResponseDto<PostResponseDto> updatePost(Long postId, PostRequestDto dto) {
        try{
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new IllegalArgumentException("retry again"));
            post.setTitle(post.getTitle());
            post.setContent(post.getContent());
            post.setAuthor(post.getAuthor());
                postRepository.save(post);
            return ResponseDto.setSuccess("sucess",convertToCommentResponseDto(post));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while updating student"
                    ,e);
        }

    }

    public ResponseDto<Void> deletePost(Long postId) {
        try{
            Post post  =postRepository.findById(postId)
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
    public PostResponseDto convertToCommentResponseDto(Post post) {
        List<CommentResponseDto> commentDtos = post.getComments().stream()
                .map(comment -> new CommentResponseDto(comment.getId(), post.getId(),
                        comment.getContent(), comment.getCommenter()))
                .collect(Collectors.toList());
        return new PostResponseDto(
                post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

}

