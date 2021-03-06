package com.naitech.repository.persistence;

import com.naitech.domain.persistence.MemberTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface TransactionsRepo extends JpaRepository<MemberTransactions, Long> {
    @Query(value = "select mt from Member_Transactions mt where mt.member_id=:id",nativeQuery = true)
    List<MemberTransactions> getAllTransactions(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "delete from member_transactions where member_id=:id",nativeQuery = true)
    void deleteByMemberId(@Param("id") Long id);
}
