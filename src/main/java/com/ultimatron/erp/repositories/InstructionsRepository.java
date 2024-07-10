package com.ultimatron.erp.repositories;

import com.ultimatron.erp.entities.Instructions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionsRepository extends JpaRepository<Instructions,Integer> {
}
