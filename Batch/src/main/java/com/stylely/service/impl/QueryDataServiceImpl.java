package com.stylely.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylely.db.ebiz.mapper.EbizQueryDataMapper;
import com.stylely.db.localhost.mapper.LocalhostQueryDataMapper;
import com.stylely.service.QueryDataService;

@Service
public class QueryDataServiceImpl implements QueryDataService {

	@Autowired
	private EbizQueryDataMapper ebizQueryDataMapper;
	@Autowired
	private LocalhostQueryDataMapper localhostQueryDataMapper;

	@Override
	public String queryDataService(String param) {
		return ebizQueryDataMapper.queryDataService(param) + "---"
				+ localhostQueryDataMapper.queryDataService("TL20181207111100690843769");
	}

}
