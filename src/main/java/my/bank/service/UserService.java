package my.bank.service;

import my.bank.domain.User;
import my.bank.dto.UserDto;
import my.bank.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {
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

    public UserDto findUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new UserDto(user);
    }
}
