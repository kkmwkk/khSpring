package com.korea.myboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		String kbs = "아름다운 대한민국!!!";
		model.addAttribute("datadata", kbs);
		logger.info("test : " + kbs);
		
		return "/test/korea";
	}
	
	// 웹에서 화면전환(새로고침) 없이 이루어지는 동작들은 대부분 비동기 통신으로 이루어진다.
	// 비동기통신을 하기위해서는 클라이엍느에서 서버로 요청메세지를 보낼 때,
	// 본문에 데이터를 담아서 보내야 하고, 서버에서 클라이언트로 응답을 보낼때에도 본문에 데이터를 담아서 보내야 한다.
	// 이 본문이 바로 body 이다.
	// 즉, 요청본문 requestBody, 응답본문 responseBody을 담아서 보내야 한다.
	// 서버 -> 클라이언트 응답 : @ResponseBody
	
	@RequestMapping(value="/show")
	@ResponseBody
	public String show() {
		logger.info("show show ~~~");
		return "<h2> show show ~~~~</h2>";
	}
	
}
