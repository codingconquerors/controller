package com.liveitcourses.firstproject.repository;

import com.liveitcourses.firstproject.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}