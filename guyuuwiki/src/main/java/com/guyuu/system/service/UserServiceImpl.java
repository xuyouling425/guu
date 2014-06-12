package com.guyuu.system.service;


import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guyuu.core.mappers.BaseExample;
import com.guyuu.core.service.impl.BaseServiceImpl;
import com.guyuu.system.mappers.WikiUserMapper;

@Service
public class UserServiceImpl extends BaseServiceImpl  {


	private WikiUserMapper wikiUserMapper;
	
	
	public WikiUserMapper getWikiUserMapper() {
		return wikiUserMapper;
	}

	@Resource
	public void setWikiUserMapper(WikiUserMapper wikiUserMapper) {
		super.mapper = wikiUserMapper;
		super.mapperPath = WikiUserMapper.class.getName();
		this.wikiUserMapper = wikiUserMapper;
	}


}
