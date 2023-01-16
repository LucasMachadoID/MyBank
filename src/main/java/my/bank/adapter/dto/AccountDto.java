package my.bank.adapter.dto;

import lombok.Getter;
import lombok.Setter;
import my.bank.adapter.domain.Account;
import my.bank.adapter.domain.AccountType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto implements Serializable {

    private Long id;

    private AccountType type;

    private UserDto user;

    private BigDecimal money;

    private boolean authorized;

    private LocalDateTime createdDate;

    public Account toAccount() {
        return Account.builder()
                .authorized(authorized)
                .type(type)
                .money(money)
                .user(user.toUser())
                .build();
    }

    public AccountDto(Account account) {
        this.id = account.getId();
        this.type = account.getType();
        this.money = account.getMoney();
        this.authorized = account.isAuthorized();
        this.createdDate = account.getCreatedDate();
    }

}
