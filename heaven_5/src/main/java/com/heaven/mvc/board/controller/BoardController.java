package com.heaven.mvc.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.heaven.mvc.board.domain.BoardVO;
import com.heaven.mvc.board.service.BoardService;

@Controller
@SessionAttributes("boardVO")
public class BoardController {
	
	
	// @SessionAttributes가 제공해주는 기능은 2가지가 있다.
	// 첫째로 컨트롤러의 메서드가 생성하는 모델정보 중에서 @SessionAttributes에 지정한 이름에 동일한 것이 있으면 이를 세션에 저장한다.
	// 위의 상황에서는 boardVO 오브젝트가 모델에 저장되는 동시에 세션에도 저장된다. 지정한 이름이 동일하기 때문이다.
	// 둘째로 파라미터에 @ModelAttribute 어노테이션이 있을 때 여기 전달할 오브젝트를 세션에서 가져오는 것이다.
	// 원래는 파라미터에 @ModelAttribute가 있으면 새 오브젝트를 생성한 뒤 HTTP 요청 파라미터를 바인딩한다.
	// 하지만 @SessionAttributes를 사용했을 경우는 다르다.
	// 새 오브젝트를 생성하기 전 @SessionAttributes에 지정된 이름과 @ModelAttribute 파라미터의 이름을 비교하여 동일할 경우 오브젝트를 새로 생성하지 않고 세션에 있는 오브젝트를 사용하게 된다.
	
		
	
	@Autowired
	private BoardService boardService;
	
	public BoardService getBoardService() {
		return boardService;
	}
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value = "/board/list")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.list());
		return "/board/list";
	}
	
	@RequestMapping(value = "/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVO", boardService.read(seq));
		return "/board/read";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		return "/board/write";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/board/write";
		}else {
			boardService.write(boardVO);
			return "redirect:/board/list";
		}
	}
	
	@RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVO boardVO = boardService.read(seq);
		model.addAttribute("boardVO", boardVO);
		return "/board/edit";
	}
	
	@RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute BoardVO boardVO, BindingResult result, int pwd, SessionStatus sessionStatus, Model model) {
		if(result.hasErrors()) {
			return "/board/edit";
		}else {
			if(boardVO.getPassword() == pwd) {
				boardService.edit(boardVO);
				sessionStatus.setComplete(); // 현재 컨트롤러 세션에 저장된 모든 정보를 제거한다. 개별적으로 제거할 순 없다.
			}
			
			// @SessionAttributes를 사용해 세션에 저장한 모델이 더 이상 필요 없어질 경우 세션에서 제거해줘야 한다.
			// 세션의 제거 시점은 스프링이 알 수 없으므로 이를 제거하는 책임은 컨트롤러에게 있다.
			// 세션의 경우 서버의 메모리를 사용하므로 필요없는 시점에 제거해주지 않으면
			// 메모리 누수가 발생할 수 있기 때문에 항상 빼먹지 않고 제거해줘야한다.
			
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/edit";
		}
	}
	
	@RequestMapping(value = "/board/delete/{seq}", method = RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model) {
		model.addAttribute("seq", seq);
		return "/board/delete";
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String delete(int seq, int pwd, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setPassword(pwd);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount == 0) {
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다");
			return "/board/delete";
		}else {
			return "redirect:/board/list";
		}
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		return "<h1>"+ "안녕하세요" + "</h1>";
	}
}
