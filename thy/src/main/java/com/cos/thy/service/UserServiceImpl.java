package com.cos.thy.service;


import java.util.List;
import java.util.Optional;
import com.cos.thy.domain.User;
import com.cos.thy.persistent.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Optional<User> findById(int userid) {
        return userRepository.findById(userid);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int userid) {
        userRepository.deleteById(userid);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findByCustom(int userid) {
        return userRepository.findByCustom(userid);
    }
}