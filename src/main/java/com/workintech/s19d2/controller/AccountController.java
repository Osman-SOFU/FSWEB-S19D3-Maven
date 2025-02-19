package com.workintech.s19d2.controller;

import com.workintech.s19d2.dto.AccountResponse;
import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable long id) {
        return accountService.find(id);
    }

    @PostMapping
    public AccountResponse save(@RequestBody Account account){
        Account saved = accountService.save(account);
        return new AccountResponse(saved.getName());
    }

    @PutMapping("/{id}")
    public AccountResponse update(@PathVariable("id") long id, @RequestBody Account account) {
        Account finded = accountService.find(id);
        accountService.update(account);
       return new AccountResponse(account.getName());
    }

    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable long id){
        Account account = accountService.find(id);
        if(account == null){
            throw new RuntimeException("no account.");
        }
        accountService.delete(id);
        return new AccountResponse(account.getName());
    }
}
