package com.stylely.db.ebiz.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EbizQueryDataMapper {
	public String queryDataService(String param);
}
