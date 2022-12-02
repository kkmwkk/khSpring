package com.korea.myboard.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;

}
