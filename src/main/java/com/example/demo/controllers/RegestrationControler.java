package com.example.demo.controllers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.EmailExistsException;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegestrationControler {
    private UserService userService;

    @GetMapping("registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        System.out.println("Registration?");
        model.addAttribute("userDTO", userDto);
        return "th_registration";
    }

    @PostMapping("/reg")
    public ModelAndView registerUserAccount(
            @ModelAttribute("userDTO") @Valid UserDTO accountDto,
            BindingResult result,
            WebRequest request,
            Errors errors) {
        System.out.println("eeeeeeeeeeeeeeee");
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }

    private User createUserAccount(UserDTO accountDto, BindingResult result) {
        User registered = new User();
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}