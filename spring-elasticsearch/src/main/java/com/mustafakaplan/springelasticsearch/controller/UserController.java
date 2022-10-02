package com.mustafakaplan.springelasticsearch.controller;

import com.mustafakaplan.springelasticsearch.entity.User;
import com.mustafakaplan.springelasticsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setId("K0001");
        user.setName("Mustafa");
        user.setSurname("KAPLAN");
        user.setAddress("test address");
        user.setBirthDate(Calendar.getInstance().getTime());
        userService.saveUser(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsersByName(@RequestParam String search) {
        return ResponseEntity.ok().body(userService.getUsersByName(search));
    }

    @GetMapping("name-surname")
    public ResponseEntity<List<User>> getByNameAndSurname(@RequestParam String search) {
        return ResponseEntity.ok().body(userService.getByNameAndSurname(search));
    }
}
