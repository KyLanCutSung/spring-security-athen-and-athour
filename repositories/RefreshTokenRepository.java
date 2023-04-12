package com.example.test.repositories;

import com.example.test.entities.RefreshToken;
import com.example.test.entities.UserEntity;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    @Transactional
    @Modifying
    int deleteByUserEntity(UserEntity userEntity);
}
