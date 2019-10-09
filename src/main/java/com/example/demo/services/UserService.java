package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.EmailExistsException;
import com.example.demo.models.User;
import com.example.demo.repositories.AuthorityRepository;
import com.example.demo.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")

public class UserService implements IUserService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository/*, *//*RoleRepository roleRepository,*//*
                       BCryptPasswordEncoder bCryptPasswordEncoder*/) {
        this.userRepository = userRepository;
        /*this.roleRepository = roleRepository;*/
      //  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(x -> list.add(x));
        return list;
    }
    public User saveUser(UserDTO userDto) {
        User user=new User();
       // user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    //    user.setFirstName(userDto.getFirstName());
     //   user.setSureName(userDto.getSureName());
       // user.setUserName("glonek");
        /*Role userRole = roleRepository.findByRole("ADMIN");*/
      //  user.setRoles(userDto.getRole());
        userRepository.save(user);
        return user;
    }

  /*  @Override
    public User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException {
        System.out.println("akuna");
        return saveUser(accountDto);
    }*/
   @Override
   public User registerNewUserAccount(UserDTO accountDto)
           throws EmailExistsException {

       if (emailExists(accountDto.getEmail())) {
           throw new EmailExistsException("There is an account with that email address:"  + accountDto.getEmail());
       }
       User user = new User();
    /*   user.setFirstName(accountDto.getFirstName());
       user.setSureName(accountDto.getSureName());
       user.setPassword(accountDto.getPassword());
       user.setEmail(accountDto.getEmail());*/
      // Authority userRole = authorithyRepository.findByRole("ROLE_ADMIN");
      // user.setAuthorities(accountDto.getRole());
       return userRepository.save(user);
   }
    private boolean emailExists(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
