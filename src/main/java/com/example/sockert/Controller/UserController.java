package com.example.sockert.Controller;

import com.example.sockert.Model.Users;
import com.example.sockert.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserApi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody Users user){
        Users user1 =userRepo.findAllByUserName(user.getUserName());
        if(user1 != null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else{
            userRepo.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> usersList =userRepo.findAll();
        if(usersList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(usersList,HttpStatus.OK);
        }
    }

}
