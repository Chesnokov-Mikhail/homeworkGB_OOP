package org.example.seminar7.controller;

import org.example.seminar7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userListPage (Model model){
        model.addAttribute("users", userService.findAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.findById(id)
                .orElseThrow(NotFoundExeption::new));
        return "user_form";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String NotFoundExeptionHanfler(NotFoundExeption ex) {
        return "not_found";
    }
}
