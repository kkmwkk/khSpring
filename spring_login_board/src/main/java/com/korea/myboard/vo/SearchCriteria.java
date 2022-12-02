package com.korea.myboard.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria extends Criteria{
	
	private String searchType = "";
	private String keyword = "";
	

}
