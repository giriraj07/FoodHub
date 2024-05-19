package org.giriraj.Services;

import org.giriraj.Model.Orders;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerHistoryService implements CustomerHistory {
    private HashMap<Long, List<Orders>> custHistoryMap;

    public CustomerHistoryService(HashMap<Long, List<Orders>> custHistoryMap) {
        this.custHistoryMap = custHistoryMap;
    }

    @Override
    public void addOrders(long custId, Orders order){
        if(custHistoryMap.containsKey(custId))
            custHistoryMap.get(custId).add(order);
        else
            custHistoryMap.put(custId, Collections.singletonList(order));
    }

    @Override
    public List<Orders> getAllOrdersPlaced(long custId) {
        return custHistoryMap.get(custId);
    }
}
