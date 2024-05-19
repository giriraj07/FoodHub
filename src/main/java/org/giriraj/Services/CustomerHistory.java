package org.giriraj.Services;

import org.giriraj.Model.Orders;

import java.util.List;

public interface CustomerHistory {

    void addOrders(long custId, Orders order);
    List<Orders> getAllOrdersPlaced(long custId);

}
