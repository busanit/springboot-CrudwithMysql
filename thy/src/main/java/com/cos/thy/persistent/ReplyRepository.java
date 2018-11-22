package com.cos.thy.persistent;

import java.util.List;

import com.cos.thy.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    @Query(value="select max(replyid) from reply", nativeQuery=true)
    int findLastReplyid();
    @Query(value="select * from reply where boardid = ?1", nativeQuery=true)
    List<Reply> findByCustomBoardid(int boardid); 
}