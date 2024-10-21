package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//회원(User)엔티티
//id: bigint  -기본키,자동증가(일련 번호)
//email.varchar(255) notnull
//password :varchar(255) notnull
//create_at deatetime,not null
//updated-at datetime not null
@Entity
@Table(name = users)
@NoArgsConstructor
@Getter
//UserDetails 인터페이스를 상속받아 인증 객체로 사용
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id", unique = false)
    private  Long Id;
    @Column(name ="email", nullable = false,unique = true)
    private  String email;
    @Column(name ="password",nullable = false,unique = true)
    private  String password;
    @Builder
    public  User(String email, String password ,String auth){
        this.email=email;
        this.password=password;
    }
    /*
    UserDetails  인터페이스
    :사용자의 인증정보를 담고 있는 객체를 정의하는 인터페이스
    Spring Security가 사용자의 권한 및 인증 관련 정보를 확인할 떄 사용

     */
    public Collection < ?extends GrantedAuthority> getAuthorities(){
        //사용자가 가지고 있는 권한(roles) 목록 반환
        //ex 일반 사용자 관리자 임원등의 권한이 있을경우
        //가지고 있는 권한 모두 반환
        return  List.of(new SimpleGrantedAuthority("user"));
    }
    @Override
    public  String getUsername(){
        return  email;
    }

    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public  boolean isAccountNonLocked(){
        return  true;
    }
    @Override
    public  boolean isCredentialsNonExpired(){
        return  true;
    }
    @Override
    public  boolean isEnabled(){
        return  true;
    }

}
