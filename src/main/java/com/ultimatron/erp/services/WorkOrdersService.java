package com.ultimatron.erp.services;

import com.ultimatron.erp.dto.WorkOrderDto;
import com.ultimatron.erp.entities.States;
import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.entities.WorkOrders;
import com.ultimatron.erp.mapper.WorkOrdersMapper;
import com.ultimatron.erp.repositories.StatesRepository;
import com.ultimatron.erp.repositories.UsersRepository;
import com.ultimatron.erp.repositories.WorkOrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class WorkOrdersService {
    private WorkOrdersRepository workOrdersRepository;
    private StatesRepository statesRepository;
    private UsersRepository usersRepository;
    private WorkOrdersMapper workOrdersMapper;

    public void addOrder(WorkOrders order) {
        //"OPEN" default id is 1
        Optional<States> state = statesRepository.findById(1);
        order.setState(state.get());
        order.setReplaceAdvance(false);
        workOrdersRepository.save(order);
    }

    public List<WorkOrderDto> findAllById(Integer id) {
        Users user = usersRepository.findById(id).get();
        List<WorkOrders> workOrders = user.getOrders();
        List<WorkOrderDto> workOrderDtos = workOrders.stream().map(workOrdersMapper::toWorkOrderDto).collect(Collectors.toList());
        System.out.println(workOrderDtos);
        return workOrderDtos;
    }
}
