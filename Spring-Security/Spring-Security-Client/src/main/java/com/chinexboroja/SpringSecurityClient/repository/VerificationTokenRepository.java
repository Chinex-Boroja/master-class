package com.chinexboroja.SpringSecurityClient.repository;

import com.chinexboroja.SpringSecurityClient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
