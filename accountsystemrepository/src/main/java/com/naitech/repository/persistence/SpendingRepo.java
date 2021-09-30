package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepo extends JpaRepository<Spending, Long> {
}
