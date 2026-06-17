package com.betacom.pv.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.pv.interfaces.IMessaggiServices;
import com.betacom.pv.models.Messaggi;
import com.betacom.pv.models.MessaggioID;
import com.betacom.pv.repository.IMessaggiRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MessaggioImpl implements IMessaggiServices {
	
	private final IMessaggiRepository repM;
	@Value("${lang}")
	private String lang;
	
	@Override
	public String get(String code) {
		log.debug("get");
		String r = null;
		Optional<Messaggi> m = repM.findById(new MessaggioID(lang, code));
		if (m.isEmpty())
			r=code;
		else
			r=m.get().getMessaggio();
		
		return r;
	}

}
