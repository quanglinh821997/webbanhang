package com.microtech.controller;

import com.microtech.dto.UserDTO;
import com.microtech.global.GlobalData;
import com.microtech.model.Role;
import com.microtech.model.User;
import com.microtech.repository.RoleRepo;
import com.microtech.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/login")
    public String login(){

        return "login";
    } // page login

    @GetMapping("/forgotpassword")
    public String forgotPass(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "forgotpassword";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    } // page register

    @PostMapping("/register")
    public String registerPost(@ModelAttribute User userModel, HttpServletRequest request) throws ServletException {
        // chuyen password tu form dki thanh dang ma hoa
        String password = userModel.getPassword();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));

        // set mac dinh role user, admin
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepo.findById(1).get());
        roles.add(roleRepo.findById(2).get());
        userModel.setRoles(roles);
        userRepo.save(userModel);

        // login & chuyen den page home
        request.login(userModel.getEmail(), password);
        return "redirect:/";
    }

}
