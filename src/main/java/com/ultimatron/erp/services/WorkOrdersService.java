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
import java.util.function.Predicate;
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
        //"OPEN" default
        Optional<States> statesOptional = statesRepository.findByState("OPEN");

        States state = statesOptional.orElseGet(()-> {
            States newState = new States();
            newState.setState("OPEN");
            return statesRepository.save(newState);
        });
        order.setState(state);
        order.setReplaceAdvance(false);
        workOrdersRepository.save(order);
    }

    public List<WorkOrderDto> findAllByUserIdAndState(Integer id,String state) {
        Users user = usersRepository.findById(id).get();
        List<WorkOrders> workOrders = user.getOrders();
        Predicate<WorkOrders> stateFilter = "CLOSE".equals(state)
                ? order -> "CLOSE".equals(order.getState().getState())
                : order -> !("CLOSE".equals(order.getState().getState()));
//        workOrders ="CLOSE".equals(state)? workOrders.stream().filter(order -> "CLOSE".equals(order.getState().getState())).collect(Collectors.toList())
//        :workOrders.stream().filter(order -> !("CLOSE".equals(order.getState().getState()))).collect(Collectors.toList());
        List<WorkOrderDto> workOrderDtos = workOrders.stream().filter(stateFilter).map(workOrdersMapper::toWorkOrderDto).collect(Collectors.toList());
        System.out.println(workOrderDtos);
        return workOrderDtos;
    }
}
