package com.ultimatron.erp.repositories;

import com.ultimatron.erp.entities.WorkOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrdersRepository extends JpaRepository<WorkOrders,Integer> {
}
