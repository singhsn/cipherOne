package com.example.cipherone.repository;

import com.example.cipherone.entity.TokenizedDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenizedDataRepository extends JpaRepository<TokenizedDataEntity, Long> {
}