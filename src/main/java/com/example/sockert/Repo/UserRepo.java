package com.example.sockert.Repo;

import com.example.sockert.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<Users, Long> {

    Users findAllByUserName(String username);
}
