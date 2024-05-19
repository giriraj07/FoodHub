package org.giriraj.Services;

import org.giriraj.Model.Orders;

import java.util.List;

public interface RiderHistory{

    void addOrdersDelivered(long riderId, Orders order);
    List<Orders> getAllOrdersDelivered(long riderId);
}
