package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.model.dto.BoardDto;
import com.spring.mvc.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired
	private BoardService service;
	
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
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		model.addAttribute("list", service.selectList());
		return "mvclist";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("dto", service.selectOne(myno));
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertform() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertres(BoardDto dto) {
		logger.info("INSERT RES");
		
		int res = service.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
		} else {
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("/updateform.do")
	public String updateform(Model model, int myno) {
		logger.info("UPDATE FORM");
		model.addAttribute("dto", service.selectOne(myno));
		return "mvcupdate";
		
	}
	@RequestMapping("/updateres.do")
	public String updateres(BoardDto dto) {
		logger.info("UPDATE RES");
		int res = service.update(dto);
		
		if(res>0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		} else {
			return "redirect:updateform.do?myno="+dto.getMyno();
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		
		int res = service.delete(myno);
		
		if(res>0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno="+myno;
		}
	}
	
}
