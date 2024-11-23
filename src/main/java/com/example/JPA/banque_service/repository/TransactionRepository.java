package com.example.JPA.banque_service.repository;

import com.example.JPA.banque_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.compte.id = :compteId")
    List<Transaction> findByCompteId(Long compteId);

    @Query("SELECT COUNT(t) FROM Transaction t")
    long countTotalTransactions();

    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = 'DEPOT'")
    Double sumTotalDeposits();

    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = 'RETRAIT'")
    Double sumTotalWithdrawals();
}