package com.example.remind.repositories;

import com.example.remind.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findUserByMemberName(String memberName);
}