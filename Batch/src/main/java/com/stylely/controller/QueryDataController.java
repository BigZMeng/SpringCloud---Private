package com.stylely.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stylely.service.QueryDataService;

@RestController
public class QueryDataController {

	@Autowired
	private QueryDataService queryDataService;

	@RequestMapping(value = "/queryData", method = RequestMethod.POST)
	public String queryData(@RequestBody String city) {
		return queryDataService.queryDataService(city);
	}

}
