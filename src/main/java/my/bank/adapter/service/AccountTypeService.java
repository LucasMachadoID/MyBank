package my.bank.adapter.service;

import my.bank.adapter.domain.AccountType;
import my.bank.adapter.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public AccountType findById(Long id) {
        return accountTypeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
