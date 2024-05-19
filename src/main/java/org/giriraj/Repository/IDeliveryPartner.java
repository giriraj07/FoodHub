package org.giriraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.giriraj.Model.DeliveryPartner;

public interface IDeliveryPartner extends JpaRepository<DeliveryPartner, Long> {

}
