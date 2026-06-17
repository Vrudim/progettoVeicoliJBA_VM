package com.betacom.pv.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="messaggi_sistema")
public class Messaggi {
	
	@EmbeddedId
	private MessaggioID msgID;
	
	private String messaggio;
}
