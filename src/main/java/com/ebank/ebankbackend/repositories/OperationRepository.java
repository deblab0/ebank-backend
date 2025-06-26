package com.ebank.ebankbackend.repositories;

import com.ebank.ebankbackend.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
// You might add custom queries here later, e.g., to find top 10 recent operations
public interface OperationRepository extends JpaRepository<Operation, Long> {
}