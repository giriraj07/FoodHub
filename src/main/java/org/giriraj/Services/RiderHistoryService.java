package org.giriraj.Services;

import org.giriraj.Model.Orders;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class RiderHistoryService implements RiderHistory {
    private HashMap<Long, List<Orders>> riderHistoryMap;

    public RiderHistoryService(HashMap<Long, List<Orders>> custHistoryMap) {
        this.riderHistoryMap = custHistoryMap;
    }

    @Override
    public void addOrdersDelivered(long custId, Orders order){
        if(riderHistoryMap.containsKey(custId))
            riderHistoryMap.get(custId).add(order);
        else
            riderHistoryMap.put(custId, Collections.singletonList(order));
    }

    @Override
    public List<Orders> getAllOrdersDelivered(long riderId) {
        return riderHistoryMap.get(riderId);
    }

}
