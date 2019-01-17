package com.stylely.db.localhost.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocalhostQueryDataMapper {
	public String queryDataService(String param);
}
