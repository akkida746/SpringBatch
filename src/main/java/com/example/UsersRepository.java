package com.example;

/**
 * @author Akash Deep
 * @date 11/10/2019
 **/
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}