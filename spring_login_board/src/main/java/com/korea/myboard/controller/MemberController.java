package com.korea.myboard.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korea.myboard.service.MemberService;
import com.korea.myboard.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	
	// 회원가입 GET
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void getRegister() throws Exception{
		logger.info("get register 2022 1201");
	}
	
	// 회원가입 POST
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String getRegister(MemberVO vo) throws Exception{
		logger.info("post register");
		service.register(vo);
		
		return "redirect:/";
	}
	
	// 로그인 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() throws Exception{
		logger.info("GET LOGIN 작동");
	}
	
	// 로그인 POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		logger.info("POST LOGIN 작동");
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else{
			session.setAttribute("member", login);
			logger.info("member : " + login);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberUpdateView", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{
		return "member/memberUpdateView";
	}
	
	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		service.memberUpdate(vo);
		session.invalidate();
		return "redirect:/";
	}
	
	
}
