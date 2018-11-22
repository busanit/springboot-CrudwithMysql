package com.cos.thy.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Reply{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int replyid;
    private String content;

    @ManyToOne
    @JoinColumn(name="boardid")
    private Board board;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;
}