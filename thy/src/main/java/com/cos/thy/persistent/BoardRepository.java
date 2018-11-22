package com.cos.thy.persistent;

import com.cos.thy.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Board findByBoardid(int boardid);
    @Modifying
    @Query(value="update board set readcount = readcount + 1 where boardid = ?1", nativeQuery=true)
    void updateReadCount(int boardid);
}