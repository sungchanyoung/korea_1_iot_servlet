package org.example.springbootdeveloper.이론;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

class Book1{
    private  String title;
    public Book1(String title ){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
}//전통적인 자바 코드 방식 : 객체 생성과 관리를 개발자가 직접 정의
class BookStore1{
    private  Book1 book;
    public BookStore1(){
        this.book = new Book1("Java 기초");
    }
    public void displayBook(){
        System.out.println("Book : "+book.getTitle());
    }
}
@Component
class Book2{
    private String title;
    public  Book2(){
        this.title = "스프링 기초";
    }
    public String getTitle(){
        return this.title;
    }
}
@Component
class BookStore2{
    private Book2 book;
    @Autowired
    public BookStore2(Book2 book){
        this.book =book;
    }
    public void displayBook(){
        System.out.println("Book : "+ book.getTitle());
    }
}



public class e_IoC_DI {
    public static void main(String[] args) {
        BookStore1 store1 = new BookStore1();
        store1.displayBook();

        // 정말로중요한 개념
        // 1.제어의 역전 (Inversion of Control)
//      : 프로그램 의 제어 흐름을 개발자가 아닌 '외부 컨테이너'에 위임하는 방식
//      제어의 권한이 컨테이너 에게 넘어가 갹체의 생명 주기를 컨테이너가 관리
//    cf) 전통적인 프로그래밍
//    : 개발자가 객체의 생성부터 소멸 까지 직접 제어
//
        // 2. 의존성 주입
//    DI (Dependency Injection )
//    : 제어의 역전을 구현하기 위해 사용하는방법 어떤 클래스가 다른 클래스에 의존한다
//    객체 간의 결합도를 낮추고 유연성과 재사용성을 높이며 코드의 테스트가 용이
//    생성자 주입 ,필드 주입 세터 주입등의 방식으로 이루어짐
//    @autowired: 스프링 컨테이너에 있는 빈 이라는것 주입하는 역할
//        cf) 빈-콩 (Bean): 스프링 컨테이너에서 관리하는 객체
//
    }

}