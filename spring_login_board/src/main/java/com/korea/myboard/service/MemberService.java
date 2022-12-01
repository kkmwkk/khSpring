package com.korea.myboard.service;

import com.korea.myboard.vo.MemberVO;

public interface MemberService {
	
	public void register(MemberVO vo) throws Exception;
	public MemberVO login(MemberVO vo) throws Exception;
	public void memberUpdate(MemberVO vo) throws Exception;
	public void memberDelete(MemberVO vo) throws Exception;

}
