package my.bank.adapter.controller;

import my.bank.adapter.domain.User;
import my.bank.adapter.dto.UserDto;
import my.bank.adapter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    private ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto userSaved = userService.saveUser(user);
        return ResponseEntity.ok(userSaved);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDto> findUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserDto(user));
    }

    @GetMapping("/list")
    private ResponseEntity<Page<UserDto>> listUsers(Pageable pageable) {
        Page<UserDto> users = userService.listUsers(pageable);
        return ResponseEntity.ok(users);
    }
}
