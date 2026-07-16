package com.smartatm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smartatm.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {


    Account findByAccountNumber(String accountNumber);


}