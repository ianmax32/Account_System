package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
    @Query(value = "select * from members m where m.member_name=:name and m.member_surname=:surname",nativeQuery = true)
    public Member getID(@Param("name") String name, @Param("surname") String surname);

    @Modifying
    @Transactional
    @Query(value = "update members set member_plays=:plays where member_id=:id",nativeQuery = true)
    public void updateMemberPlaysCurr(@Param("id") Long id, @Param("plays") int plays);

    @Query(value = "select member_plays from members where member_id=:id",nativeQuery = true)
    public int curMemberPlays(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update members set current_amount=:amount where member_id=:id",nativeQuery = true)
    public void updateMemberAmount(@Param("id") Long id, @Param("amount") double amount);

    @Modifying
    @Transactional
    @Query(value = "select current_amount from members where member_id=:id",nativeQuery = true)
    public double getCurrentAmount(@Param("id") Long id);


}
