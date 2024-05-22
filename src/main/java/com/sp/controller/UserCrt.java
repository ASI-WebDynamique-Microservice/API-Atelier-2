package com.sp.controller;

import com.sp.DTO.InfoUser.InfoUserResponceDTO;
import com.sp.DTO.Login.LoginRequestDTO;
import com.sp.DTO.Login.LoginResponseDTO;
import com.sp.DTO.UserDTO;
import com.sp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
//@RequestMapping("/user")
public class UserCrt {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/user/new"}, method = RequestMethod.POST)
    public ResponseEntity<String> newUser(@RequestBody UserDTO user)
    {
        userService.newUser(user);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        return new LoginResponseDTO()
                .setToken(userService.login(loginRequestDTO));
    }

    @RequestMapping(value = {"/user/info"}, method = RequestMethod.GET)
    public InfoUserResponceDTO infoUser(@RequestHeader("TOKEN") String token) {
        return userService.getInfoUser(token);
    }

}
