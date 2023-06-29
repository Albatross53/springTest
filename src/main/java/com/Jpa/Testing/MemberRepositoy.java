package com.Jpa.Testing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoy extends JpaRepository<Member, Long> {
}
