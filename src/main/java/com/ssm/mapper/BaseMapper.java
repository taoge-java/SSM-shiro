package com.ssm.mapper;

import java.util.List;

import com.ssm.entity.BaseEntity;


public interface BaseMapper<T extends BaseEntity<T>> {
	
	public T findById(int id);
	
	public T findByUserName(String userName);
	
	public List<T> findList();
	
	public void update(T entity);

}
