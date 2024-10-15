package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.StudentDto;
import org.example.springbootdeveloper.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller + ResponseBody가 결합된 애너테이션
//RESTful 웹 서비스의 컨트롤러임을 명시
@RestController
//RequestMapping("경로")
//:해당 컨트롤러의 모든 요청 URL이 "/api/students로 시작함을 정의"
@RequestMapping("/api/students")
public class StudentController {
    //비즈니스 로직을 처리하는 Service 객체를 주입 받아 사용
    private  final StudentService studentService;
    //생성자 주입 (DI)
    //외부에서 StudentService 객체를 주입 받아 초기화
    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }
    //1) 학생 목록 조회 -get:모든 학생 목록 반환
    @GetMapping//http get 요청을 처리 "./api/students"경로에 매핑
    public List<StudentDto>getAllStudents(){
        return studentService.getAllStudents();
    }
    //2)ID로 학생 조회
    //api/students/{id} 경로로 오느get요청을 처리
    //{id}경로로 변수로 사용
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
//        @PathVariable  :url 경로에 전달된 id 값을 메서드 파라미터로 매핑
        return  studentService.getStudentById(id);
    }
//    3) 학생등록(post) 새로운 학생 데이터 등록
//    http post 요청을 처리 "api/students"경로와 매핑

//    @PostMapping
//    public StudentDto createStudent(@RequestBody StudentDto studentDto){
//        //@Requesbody :클라이언트에서 전달된 json 데이터를Studnet dto 객체로 반환
//
//        return  studentService.createStudent(studentDto);
//    }
    //4 학생 정보 수정 put-특정 id의 학생 정보를 수정
    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return  studentService.updateStudent(id,studentDto);
    }
//    //5학생정보 삭제(delete) -> 특정 id의 학생 정볼를 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
        //반환할 데이터가 없다
        //:http 상태코드의 204 NO content를 반환 :본문 없이 응답을 완료시킴
    }




}
