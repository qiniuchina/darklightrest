package com.dxc.darklightrest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.darklightrest.entity.KpiMorningStar;
import com.dxc.darklightrest.repository.KpiMorningStarRepository;
import com.dxc.darklightrest.service.KpiMorningStarService;

@Service
public class KpiMorningStarServiceImpl implements KpiMorningStarService {

	@Autowired
	private KpiMorningStarRepository kpiMorningStarRepository;
	
	@Override
	public List<KpiMorningStar> findAll() {	
		return kpiMorningStarRepository.findAll();
	}

}
