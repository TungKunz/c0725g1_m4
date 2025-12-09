package org.example.formsignup.repository;

import org.example.formsignup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User,Integer> {
}
