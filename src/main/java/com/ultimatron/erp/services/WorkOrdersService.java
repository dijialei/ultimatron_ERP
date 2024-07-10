package com.ultimatron.erp.services;

import com.ultimatron.erp.repositories.WorkOrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class WorkOrdersService {
    private WorkOrdersRepository workOrdersRepository;
}
