package org.example.springbootdeveloper.이론;
//기본 구조
class cat{//클래스 생성
    //필드 : 데이터를 저장하는곳
    // 고양이 이름 나이 -> 객체가 생성 될떄  객체를 초기화 합니다
    String name;
    int age;
    //생성자 : 어떤 객체가 생성과 동시에 우효함을 보장하는 역할
    // 생성자도 메서드 의 일종이다
    // 초기화를 당당한다
    public  cat(String name, int age){
        this.age=age;
        this.name=name;
    }
    public  void Mewo(){
        System.out.println("양옹");
    }
}
public class Class01 {
    public static void main(String[] args) {
      // 객체 생성 -> 나비라는 이름, 3살 이라는 고양이 객체를 생성
        cat cat =new cat("나비",3);
        cat.Mewo();
    }
}
