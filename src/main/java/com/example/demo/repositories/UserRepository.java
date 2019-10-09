package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByUserNameIsNotNull(Pageable pageable);

    User findByFirstName(String username);
    User findByUserName(String login);
    User findByEmail(String email);
}
