package technocite.be.takemymoney.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import technocite.be.takemymoney.api.dto.OweDto;
import technocite.be.takemymoney.api.dto.UserDto;
import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.model.User;
import technocite.be.takemymoney.service.OweService;
import technocite.be.takemymoney.service.UserService;

import javax.annotation.PostConstruct;
//add methode searchByUserBorrowId
@Controller
@RequestMapping ("/User")
public class UserOweController {


    @Autowired
    private UserService userService;


    @GetMapping(value = "/user/{email}")
    public ResponseEntity<UserDto> FindByemail(String email){
        UserDto userDto = userService.findByEmail(email);

        if (userDto != null ){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto){
      return userService.addUser(userDto);
    }



}
