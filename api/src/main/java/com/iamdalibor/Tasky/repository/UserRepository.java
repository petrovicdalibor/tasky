package com.iamdalibor.Tasky.repository;

import com.iamdalibor.Tasky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
