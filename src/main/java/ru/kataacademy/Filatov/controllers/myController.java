package ru.kataacademy.Filatov.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kataacademy.Filatov.model.User;
import ru.kataacademy.Filatov.services.UsersService;

@Controller
@RequestMapping("/user")
public class myController {
    private final UsersService usersService;

    @Autowired
    public myController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersService.findOne(id));
        return "pages/showuser";
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "pages/allusers";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/newuser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "pages/newuser";
        }
        usersService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersService.findOne(id));
        return "pages/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id
            , @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/edit";
        }
        usersService.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersService.delete(id);
        return "redirect:/user";
    }
}
