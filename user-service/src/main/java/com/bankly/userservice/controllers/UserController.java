package com.bankly.userservice.controllers;

import com.bankly.userservice.dto.AutenticateRequest;
import com.bankly.userservice.dto.ResponseDto;
import com.bankly.userservice.dto.UserAppDto;
import com.bankly.userservice.entities.UserApp;
import com.bankly.userservice.services.IUserAppService;
import com.bankly.userservice.utiles.DtoToEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    AuthenticationManager authenticationManager;
    private IUserAppService userAppService;


    public UserController(AuthenticationManager authenticationManager, IUserAppService userAppService) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
    }

    @PostMapping("/register")
    public ResponseDto register(@RequestBody UserAppDto userAppDto){
        UserApp userApp = DtoToEntity.operationDtoToOperationEntity(userAppDto);
        return userAppService.addUser(userApp);
    }

    @GetMapping("/validate-token")
    public UserApp validateToken(@PathParam("token") String token){
        return userAppService.validateToken(token);
    }

    @PostMapping("/login")
    public ResponseDto login(@RequestBody AutenticateRequest auth){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getEmail(),auth.getPassword()));
        UserApp userApp = (UserApp) userAppService.findByEmail(auth.getEmail()).getData();
        System.out.println(userApp);
        return userAppService.generateToken(userApp);
    }
}
