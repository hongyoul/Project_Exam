package com.example.demo.result;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ApiResult;
import com.example.demo.repository.ApiResultRepository;

@SpringBootTest
public class ApiResultRepositoryTest {

	@Autowired
	ApiResultRepository repository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		System.out.println("repository = " + repository);
	}
	
	@Test
	public void 데이터추가() {

		ApiResult apiResult = ApiResult.builder()
								.apiCallTime(LocalDateTime.now())
								.resultCode("01")
								.resultMsg("OK")
								.totalCount(10)
								.build();
		
		repository.save(apiResult);
	}
	
	@Test
	public void 데이터단건조회() {
		
		Optional<ApiResult> result = repository.findById(1); 
		
		if (result.isPresent()) {
			ApiResult apiResult = result.get();
			System.out.println(apiResult);
		}
	}
	

	@Test
	public void 데이터전체조회() {
		// 조회결과를 리스트로 반환
		List<ApiResult> list = repository.findAll(); 
		
		for (ApiResult apiResult : list) {
			System.out.println(apiResult);
		}
	}
	
	@Test
	public void 데이터수정() {
		
		Optional<ApiResult> result = repository.findById(2);
		ApiResult apiResult = result.get();
		apiResult.setResultMsg("수정)OK");
	}
	
	@Test
	public void 데이터삭제() {
		repository.deleteById(2); 
	}

}
