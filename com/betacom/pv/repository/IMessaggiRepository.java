package com.betacom.pv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.pv.models.Messaggi;
import com.betacom.pv.models.MessaggioID;


public interface IMessaggiRepository extends JpaRepository<Messaggi, MessaggioID> {

}
