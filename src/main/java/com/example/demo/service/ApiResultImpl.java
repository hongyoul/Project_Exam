package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResultDTO;
import com.example.demo.entity.ApiResult;
import com.example.demo.repository.ApiResultRepository;

@Service
public class ApiResultImpl {

	@Autowired
	ApiResultRepository repository;
	
	public int register(ApiResultDTO dto) {

		System.out.println(dto);

		ApiResult entity = dtoToEntity(dto); 
		repository.save(entity); 
		int newNo = entity.getNo();

		System.out.println(entity);

		return newNo; 
	}

	private ApiResult dtoToEntity(ApiResultDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
