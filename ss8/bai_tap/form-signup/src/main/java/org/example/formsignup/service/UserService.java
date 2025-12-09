package org.example.formsignup.service;

import org.example.formsignup.entity.User;
import org.example.formsignup.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public boolean add(User user) {
        return userRepository.save(user)!=null;
    }
}
