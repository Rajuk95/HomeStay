package com.practo.service;

import com.practo.entity.User;
import com.practo.payload.LoginDto;
import com.practo.payload.UserDto;
import com.practo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    public User addUser(UserDto userDto){
        User user =new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setUserRole(userDto.getUserRole());
        user.setPassword(BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt(10)));

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public String verifyLogin(LoginDto loginDto){
        Optional<User> opUser = userRepository.findByUsername(loginDto.getUsername());
        if (opUser.isPresent()){
            User urs = opUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(),urs.getPassword())){
             return  jwtService.generateToken(urs);
            }
        }
        return null;
    }
}
