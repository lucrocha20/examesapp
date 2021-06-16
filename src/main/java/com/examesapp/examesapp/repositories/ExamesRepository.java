package com.examesapp.examesapp.repositories;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamesRepository {
	
	@Autowired
	DataSource datasource;
	
	

}
