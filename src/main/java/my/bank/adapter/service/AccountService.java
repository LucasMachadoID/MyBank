package my.bank.adapter.service;

import my.bank.adapter.domain.Account;
import my.bank.adapter.domain.AccountType;
import my.bank.adapter.domain.User;
import my.bank.adapter.dto.AccountDto;
import my.bank.adapter.producer.AccountProducer;
import my.bank.adapter.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountProducer accountProducer;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountTypeService accountTypeService;

    public AccountDto createAccount(Account account) {
        buildAccountFields(account);
        Account accountSaved = accountRepository.save(account);
        accountProducer.sendEvent(accountSaved);
        return new AccountDto(account);
    }

    private void buildAccountFields(Account account) {
        User user = userService.findById(account.getUser().getId());
        AccountType accountType = accountTypeService.findById(account.getType().getId());
        account.setUser(user);
        account.setType(accountType);
    }
}
