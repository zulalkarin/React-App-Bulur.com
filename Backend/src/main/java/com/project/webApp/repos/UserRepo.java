package com.project.webApp.repos;

import com.project.webApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}
