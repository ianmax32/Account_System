package com.naitech.repository.persistence;

import com.naitech.domain.persistence.AccountType;
import com.naitech.domain.persistence.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {
    @Query(value = "select account_type_place_holder from account_type where account_type_place_holder=:name",nativeQuery = true)
    public AccountType getAccountTypeUniqueName(@Param("name") String name);

}
