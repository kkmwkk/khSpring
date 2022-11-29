package com.heaven.mvc.board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("boardVO")

public class BoardVO {
	private int seq;
	@Length(min=2, message="제목은 2자 이상 입력하세요.")
	private String title;
	@NotEmpty(message = "내용을 입력하세요.")
	private String content;
	@NotEmpty(message = "작성자를 입력하세요.")
	private String writer;
	
	
	private int password;
	private Timestamp regDate;
	private int cnt;
}
