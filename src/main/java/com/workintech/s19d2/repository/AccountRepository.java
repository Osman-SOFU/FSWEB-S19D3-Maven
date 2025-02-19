package com.workintech.s19d2.repository;

import com.workintech.s19d2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.name = :name")
    Optional<Account> findByName(String name);

    @Query("UPDATE Account a SET a.name = :name WHERE a.id = :id")
    Optional<Account> update(long id, String name);
}
