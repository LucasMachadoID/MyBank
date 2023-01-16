package my.bank.adapter.service;

import my.bank.adapter.domain.User;
import my.bank.adapter.dto.UserDto;
import my.bank.adapter.repository.UserRepository;
import my.bank.usecase.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final String USER_NOT_FOUND = "USER_NOT_FOUND";

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserDto user) {
        User userSaved = userRepository.save(user.toUser());
        return new UserDto(userSaved);
    }

    public Page<UserDto> listUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return new PageImpl<>(
                users.getContent().stream().map(UserDto::new).collect(Collectors.toList()),
                pageable,
                users.getTotalElements());
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }
}
