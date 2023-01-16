package my.bank.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import my.bank.adapter.domain.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    private String name;

    private LocalDateTime birthDate;

    private List<AccountDto> accounts;

    private LocalDateTime createdDate;

    public User toUser() {
        return User.builder()
                .name(getName())
                .accounts(getAccounts().stream().map(AccountDto::toAccount).collect(Collectors.toList()))
                .birthDate(birthDate)
                .build();
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.birthDate = user.getBirthDate();
        this.accounts = user.getAccounts().stream().map(AccountDto::new).collect(Collectors.toList());
        this.createdDate = user.getCreatedDate();
    }
}
