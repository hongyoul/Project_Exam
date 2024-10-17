package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_api_result")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value="번호")
    int no;
    
    @CreatedDate 
    @Comment(value="api호출시간")
    LocalDateTime apiCallTime;
    
    @Column(length = 10, nullable = false)
    @Comment(value="결과코드")
    String resultCode;
    
    @Column(length = 10, nullable = false)
    @Comment(value="결과메세지")
    String resultMsg;
    
    @Column(nullable = true)
    @Comment(value="전체결과수")
    int totalCount;
    
}
