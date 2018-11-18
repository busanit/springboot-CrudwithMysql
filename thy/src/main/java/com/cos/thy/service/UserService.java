package com.cos.thy.service;

import java.util.List;
import java.util.Optional;
import com.cos.thy.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Page<User> findAll(Pageable pageable);
    Optional<User> findById(int id);
    void deleteById(int id);
    User save(User user); //insert, update
    List<User> findByCustom();
    //select * from user where email=? and password=?
    User findByEmailAndPassword(String email, String password);
    
    //Like연산자 쓰고 싶으면
    //Like 사용 : select ... like : 사용자 이름
    //List<User> findByUsernameLike(String username);

    //StartingWith : select ... like : username %
    //List<User> findByUsernameStartingWith(String username);

    //EndingWith : select ...와 같이 % : username
    //List<User> findByUsernameEndingWith(String username);

    //포함 : 선택 ... % : 사용자 이름 %
    //List<User> findByUsernameContaining(String username);

}