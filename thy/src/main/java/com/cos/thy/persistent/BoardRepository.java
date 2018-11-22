package com.cos.thy.persistent;

import com.cos.thy.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Board findByBoardid(int boardid);
}