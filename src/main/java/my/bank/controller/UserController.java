package my.bank.controller;

import my.bank.dto.UserDto;
import my.bank.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @PostMapping()
    private ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto userSaved = userService.saveUser(user);
        return ResponseEntity.ok(userSaved);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDto> findUser(@PathVariable Long id) {
        UserDto user = userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/list")
    private ResponseEntity<Page<UserDto>> listUsers(Pageable pageable) {
        Page<UserDto> users = userService.listUsers(pageable);
        return ResponseEntity.ok(users);
    }
}
