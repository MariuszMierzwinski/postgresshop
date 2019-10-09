package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.EmailExistsException;
import com.example.demo.models.User;

public interface IUserService {
    User registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException, EmailExistsException;
}

