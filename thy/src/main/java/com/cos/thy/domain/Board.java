package com.cos.thy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer boardid;
    private String title;
    private String content;
    private Integer readcount;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;
}