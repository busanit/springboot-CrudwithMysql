package com.cos.thy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userid;
    private String email;
    private String password;
    private String name;

    // @OneToMany(mappedBy = "user")
    // private List<Board> boards = new ArrayList<Board>();
}