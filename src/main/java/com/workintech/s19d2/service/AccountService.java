package com.workintech.s19d2.service;

import com.workintech.s19d2.entity.Account;
import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account find(Long id);

    Account save(Account account);

    Account delete(Long id);

    Account update(Account account);
}
