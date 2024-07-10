package com.ultimatron.erp.repositories;

import com.ultimatron.erp.entities.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<States,Integer> {
}
