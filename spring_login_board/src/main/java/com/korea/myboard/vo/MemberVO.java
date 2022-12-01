package com.korea.myboard.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	
	private String userId;
	private String userPass;
	private String userName;
	private Date regDate;

	
}
