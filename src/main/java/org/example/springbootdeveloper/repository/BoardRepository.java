package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoardRepository extends JpaRepository<Board ,Long> {

}
