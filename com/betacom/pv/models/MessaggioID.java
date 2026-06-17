package com.betacom.pv.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MessaggioID {

	@Column(length=4)
	private String lang;
	
	@Column(length = 20)
	private String code;
}
