package com.ultimatron.erp.repositories;

import com.ultimatron.erp.entities.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsRepository extends JpaRepository<Records,Integer> {
}
