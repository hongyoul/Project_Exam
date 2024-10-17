package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.ApiResultDTO;
import com.example.demo.entity.ApiResult;

public interface ApiResultService {

	// 등록 
		int register(ApiResultDTO dto);
	// 조회	
		Page<ApiResultDTO> getList(int no);
		
	// 수정
		void modify(ApiResultDTO dto);
		
	// 삭제
		void remove(int no);
		
	// dto를 엔티티로 변환하는 메소드
		default ApiResult dtoToEntity(ApiResultDTO dto) {

			ApiResult entity = ApiResult.builder()
					.no(dto.getNo())
					.apiCallTime(dto.getApiCallTime())
					.resultCode(dto.getResultCode())
					.resultMsg(dto.getResultMsg())
					.totalCount(dto.getTotalCount())
					.build();
			return entity;
		}

		// 엔티티를 dto로 변환하는 메소드
		default ApiResultDTO entityToDto(ApiResult entity) {

			ApiResultDTO dto = ApiResultDTO.builder()
					.no(entity.getNo())
					.apiCallTime(entity.getApiCallTime())
					.resultCode(entity.getResultCode())
					.resultMsg(entity.getResultMsg())
					.totalCount(entity.getTotalCount())
					.build();

			return dto;
		}

	
}
