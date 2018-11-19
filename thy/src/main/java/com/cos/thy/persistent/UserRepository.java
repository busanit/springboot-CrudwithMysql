package com.cos.thy.persistent;

import java.util.List;
import com.cos.thy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
    @Query(value="select * FROM user where userid=?1 order by name", nativeQuery=true)
    List<User> findByCustom(int userid);
    @Query(value="select userid, name, email, password FROM user where userid=?1", nativeQuery=true)
    User findCustomID(int userid);
}